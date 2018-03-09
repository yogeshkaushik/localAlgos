import java.util.Scanner;

import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

public class TestSocketIO {

    public static SocketIOClient c;

    public static void main(String[] args) throws InterruptedException {

	boolean reply = false;
        Configuration config = new Configuration();
        SocketConfig con = new SocketConfig();
		con.setReuseAddress(true);
		config.setSocketConfig(con);
        config.setHostname("127.0.0.1");
        config.setPort(9888);
	System.out.println("Hi:: ===================== Starting socket port 9888");
        SocketIOServer server = new SocketIOServer(config);
	server.addEventListener("chatevent", String.class, new DataListener<String>() {
            @Override
            public void onData(SocketIOClient client, String data, AckRequest ackRequest) {
			System.out.println("MessageFromUser : "+ data);
			System.out.println("Address : "+ client.getRemoteAddress());
            }
        });
        server.addConnectListener(new ConnectListener() {
			
			@Override
			public void onConnect(SocketIOClient client) {
				System.out.println("Hi : "+client.getRemoteAddress());
				c = client;
			}
		});

        server.start();
	Scanner in = new Scanner(System.in);
	while(true) {
        	String msg = in.nextLine();
        	c.sendEvent("chatevent", msg);
	}

        /*Thread.sleep(Integer.MAX_VALUE);

        server.stop();*/
    }
}
