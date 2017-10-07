import java.util.Scanner;

class NotAName extends RuntimeException
{
	NotAName(String s)
	{
		super(s);
	}
}

class InvalidEmail extends RuntimeException
{
	InvalidEmail(String s)
	{
		super(s);
	}
}

class InvalidPhone extends RuntimeException
{
	InvalidPhone(String s)
	{
		super(s);
	}
}

class InvalidMarks extends RuntimeException
{
	InvalidMarks(String s)
	{
		super(s);
	}
}



public class form {
	String name, email, phone, address;
	int roll, HSC_marks, UG_marks;
	
	void admission()
	{
		if(HSC_marks >= 60 && UG_marks >= 70)
			System.out.println("The candidate is eligible for admission.");
		else
			System.out.println("Sorry, The candidate is not eligible for admission.");
	}
	
	public static void main(String arg[])
	{
		form s = new form();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your name");
		s.name = sc.next();
		int n = s.name.length();
		for(int i=0; i<n; i++)
		{
			if(!((s.name.charAt(i)>='a' && s.name.charAt(i)<='z') || (s.name.charAt(i)>='A' && s.name.charAt(i)<='Z')))
			{
				throw new NotAName("Please use alphabets only.");
			}	
		}
		
		System.out.println("Enter your e-mail ID");
		s.email = sc.next();
		n = s.email.length();
		int ind_2 = s.email.indexOf('@');
		int ind_3 = s.email.indexOf('.');
		if( ind_2 != -1 && ind_3 != -1)
		{
			if(ind_2 + 7 < n-1)
			{
				;
			}
			else
				throw new InvalidEmail("Please enter a valid e-mail ID");
		}
		else
			throw new InvalidEmail("Please enter a valid e-mail ID");
		
		System.out.println("Enter your Roll_no");
		s.roll = sc.nextInt();
		
		System.out.println("Enter your 10 digit Mobile no");
		s.phone = sc.next();
		if(s.phone.length() != 10)
			throw new InvalidPhone("Please enter 10 digits.");
		for(int i=0; i<10; i++)
		{
			if(!(s.phone.charAt(i)>='0' && s.phone.charAt(i)<='9'))
				throw new InvalidPhone("Please enter digits only.");
		}
		
		System.out.println("Enter your High School marks for 100.");
		s.HSC_marks = sc.nextInt();
		if(s.HSC_marks > 100 || s.HSC_marks<0)
			throw new InvalidMarks("Please enter a number between 0 and 100.");
		
		System.out.println("Enter your Under Graduate marks for 100.");
		s.UG_marks = sc.nextInt();
		if(s.UG_marks > 100 || s.UG_marks<0)
			throw new InvalidMarks("Please enter a number between 0 and 100.");
		
		s.admission();
	}
}
