package ak;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class as {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate today = LocalDate.now();
		
//		LocalDate dob = LocalDate.of(1999, 10, 23);
		
//		LocalDate dob = LocalDate.of(1999, Month.OCTOBER	, 23);
		
		String dob1 = "1999-10-23";
		
		String[] str = dob1.split("-");
		String s1 = str[0];
		String s2 = str[1];
		String s3 = str[2];
		
		int year = Integer.parseInt(s1);
		int month = Integer.parseInt(s2);
		int day = Integer.parseInt(s3);
		
		LocalDate dob = LocalDate.of(year, month, day);
	
		int years = Period.between(dob,today).getYears();
		
		System.out.println(years+" years");	//22 years
		System.out.println(today);
		
	}

}
