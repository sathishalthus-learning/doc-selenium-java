package playground;

public class StringReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//learning github merge
		//Learning replaceAll
		String s="Rs.1900.50";
		String modifiedString = s.replaceAll("^[^\\d]+","");
		System.out.println(modifiedString);
				System.out.println(Double.parseDouble(modifiedString));
				

	}

}
