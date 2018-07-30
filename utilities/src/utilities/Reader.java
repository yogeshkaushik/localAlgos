package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {

	public static void main(String[] args) throws Exception {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("This is an Echo....");
		String str = "";
		while(!(str=br.readLine()).equals("close")) {
			System.out.println(str);	
		}*/
		
		List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i<=10; i++){
            list.add(i);
        }
        
        Stream<Integer> stream = list.stream();
        
        stream.filter(i -> i%2==0).forEach(System.out::println);
        
        /*List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.print(evenNumbersList);*/
        
        //Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
        //Stream.of(evenNumbersArr).forEach(p -> System.out.print(p+" "));
	}
}
