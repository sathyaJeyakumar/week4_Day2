package week4_day2_assignments;


public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Men's fashion has ( 5738 Items)";
		String str[] = s.split("\\(");
		String str1 = (s.split("\\(")[1]).split(" ")[1];
		System.out.println(str1);
		
	
	}

}
