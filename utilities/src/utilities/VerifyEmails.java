/*
 * Copyright SocialTwist Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of SocialTwist.
 * You shall not disclose such confidential information and shall use it only
 * in accordance with the terms of the source code license agreement you
 * entered into with SocialTwist.
 */

package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @since 05-Jun-2018
 * @author <a href="mailto:yogesh@revemarketing.com">Yogesh Kaushik</a>
 * @version ${version}, 05-Jun-2018, yogeshk
 */
public class VerifyEmails implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
    	System.out.println("cloned");
    	//something;
    	return super.clone();
    }
    //DB constants
    private static final String UPDATE_QUERY = "UPDATE t-a-b-l-e SET ";
    private static String host = "localhost";
    private static String dbName = "loyalty_core_"+"0000000000";
    private static String userName = "root";
    private static String password = "sh*pp@r";
    
    //Zero Bounce API constants
    static final String zero_bounc_key = "625fed253ca24d4e84e8e66d014184ad";
    static String ip = "172.16.52.142";
    String zero_bounce_targetURL = "https://api.zerobounce.net/v1/validate?apikey=" + zero_bounc_key + "&email=";

    //Email List Verify API constants
    static final String email_verify_key = "rp0I3pQrx52ZbKlycjCkm";//"rp0I3pQrx52ZbKlycjCkm";
    String email_verify_targetURL = "http://apps.emaillistverify.com/api/verifyEmail?secret=" + email_verify_key + "&email=";
    
    private BlockingQueue<String> emailLists = new ArrayBlockingQueue<String>(500);
    private ConcurrentMap<String, String> map= new ConcurrentHashMap<String, String>();
    private String filePath = "emailFiles/zeroBounceVerifyList.txt";
    private String outputCSVLoc = "emailFiles/verifiedEmailList.csv";
    
    private ExecutorService service;
    
    
    public VerifyEmails() {
        service = Executors.newCachedThreadPool();
    }
    
    public void readFile() {
        FileReader reader = null;
        BufferedReader br = null;
        try {
            reader = new FileReader(filePath);
            br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                emailLists.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found : "+e);
        } catch (IOException e) {
            System.out.println("IO Exception : " + e);
        } finally {
                try {
                    if (reader != null) reader.close();
                    if (br != null) br.close();
                } catch (IOException e) {
                    System.out.println("Exception while closing the Reader");
                }
        }
    }
    
    public void verifyEmails() {
        while (!emailLists.isEmpty()) {
            String email = emailLists.poll();//with this, now there is no need for BlockingQueue.
            service.execute(new Runnable() {
                @Override
                public void run() {
                    //String email = emailLists.poll();
                    verifyEmail(email);
                    //testVerify(email);
                }
            });
        }
    }
    
    protected void testVerify(String email) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(email, "AB");
    }

    public void verifyEmail(String email) {
        if (email == null || email == "" || email.trim() == "") {
            System.out.println("************* EMPTY EMAIL ********************");
            return;
        }
        HttpURLConnection connection = null;
        BufferedReader in = null;
        try {
            URL url = new URL(email_verify_targetURL + email);//new URL(zero_bounce_targetURL + email);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //connection.addRequestProperty("User-Agent", USER_AGENT);
            //connection.setUseCaches(false);
            connection.setDoOutput(true);
 
            in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            map.put(email, response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                try {
                    if (in != null) in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (connection != null) connection.disconnect();
        }
    }

    static void readAndUpdateDB(Map<String, String> map) throws SQLException {
        System.out.println("Loading Classes.....");
        Connection conn = null;
        PreparedStatement updatePS = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + host  + ":3306/"+dbName , userName, password);
            System.out.println("Connected to the database");
            updatePS = conn.prepareStatement(UPDATE_QUERY);
            for (Map.Entry<String, String> e : map.entrySet()) {
                int i=1;
                updatePS.setString(i++, e.getKey());
                updatePS.setString(i++, e.getValue());
                updatePS.addBatch();
                System.out.println("Added update to Batch for USER_ID : " + e.getKey());
            }
            updatePS.executeBatch();
        } catch (ClassNotFoundException e) {
            System.out.println("************* ERROR : Couldn't load JDBC Driver **************" + e);
        } catch (SQLException e1) {
            System.out.println("************* ERROR : SQLException occured **************" + e1);
        } finally {
            if (updatePS == null) updatePS.close();
            if (conn == null) conn.close();
        }
        System.out.println("############ SUCCESSFULLY UPDATED THE DB ###########");
    }
    

    private void writeToCSV() throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(outputCSVLoc);
            for (Map.Entry<String, String> e : map.entrySet()) {
                String str = e.getKey() + "," + e.getValue()/*e.getValue().substring(1, e.getValue().length()-1)*/ + "\n";
                writer.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) writer.close();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        VerifyEmails ve = new VerifyEmails();
        
        VerifyEmails clone = (VerifyEmails) ve.clone();        
        System.out.println(ve == clone);
        /*ve.readFile();
        ve.verifyEmails();
        try {
            ve.service.shutdown();
            while(!ve.service.awaitTermination(2, TimeUnit.MINUTES));
            //readAndUpdateDB(ve.map);
            ve.writeToCSV();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
