import java.util.Scanner;

class InsufficientBal extends RuntimeException
{
	InsufficientBal(String s)
	{
		super(s);
	}
}

class InvalidAmount extends RuntimeException
{
	InvalidAmount(String s)
	{
		super(s);
	}
}

class IncorrectPIN extends RuntimeException
{
	IncorrectPIN(String s)
	{
		super(s);
	}
}

class InvalidChoice extends RuntimeException
{
	InvalidChoice(String s)
	{
		super(s);
	}
}
public class ATM {
	private int password;
	private int bal = 0;
	ATM(int s)
	{
		password = s;
	}
	ATM(int s, int x)
	{
		password = s;
		bal = x;
	}
	//public void OpenAcc() throws IncorrectPIN
	{
		
	}
	public void deposit(int x)
	{
		bal += x;
		System.out.println("Your available balance is :" + bal);
	}
	public void withdraw(int x)
	{
		if(x%100 != 0)
		{
			throw new InvalidAmount("Try a multiple of hundred. Please try again");
		}
		if(x < 100)
		{
			throw new InvalidAmount("Minimum withdrawl is Rs. 100. Please try again.");
		}
		if(bal > x)
		{
			bal -= x;
			System.out.println("Your available balance is :" + bal);
		}
		else 
			throw new InsufficientBal("Insufficient Balance, available Bal :"+bal+". Try a lesser amount.");
	}
	public void CheckBal()
	{
		//OpenAcc();
		System.out.println("Your available balance is :" + bal);
	}
	public static void main(String args[])
	{
		ATM a = new ATM(2017,10000);
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter your PIN");
		int s = inp.nextInt();
		if(s != a.password)
		{
			throw new IncorrectPIN("Incorrect PIN. Try again");
		}
		System.out.print("Enter your choice:\n1.Deposit\n2.Withdraw\n3.Check Balance\n");
		int x,ch = inp.nextInt();
		switch(ch)
		{
		case 1:
			System.out.print("Enter the amount.\n");
			x = inp.nextInt();
			a.deposit(x);
			System.out.println("Transaction Successfull.");
			break;
		case 2:
			System.out.print("Enter the amount.\n");
			x = inp.nextInt();
			a.withdraw(x);
			System.out.println("Transaction Successfull.");
			break;
		case 3:
			a.CheckBal();
			break;
		default:
			throw new InvalidChoice("Please choose from the given options.");
		}
	}
}
