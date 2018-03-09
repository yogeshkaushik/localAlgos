package general.random.pojos;

public class MainClass {

	public static void main(String[] args) {
		int x = 10;
		int y = 2;
		produceLine(x,y);
	}

	private static void produceLine(int x, int y) {
		StringBuffer line = new StringBuffer("Line ===> ");
		if (x == y)
			System.out.println("Line is ==> 1+1+1+1+1...");
		
		if (x > y) {
			y++;
			int divideLineIntoGroups = x/y;
			int remainder = x%y;
			y--;
			while (y!=0) {
				int groups = divideLineIntoGroups;
				if (remainder != 0) {
					groups++;
					remainder--;
				}
				line.append(groups + "G+" + 1 + "B+");
				y--;
			}
			System.out.println(line.append(divideLineIntoGroups+"G").toString());
		} else {
			int temp = x;
			x = y;
			y = temp;
			produceLine(x, y);
		}
		
	}
}
