package investment_calculator;

import java.util.Scanner;

class Investment_Details{
	protected double principal;
	protected double rate;
	protected int time;
	
	public Investment_Details(double principal, int time, double rate) {
		this.principal = principal;
		this.time = time;
		this.rate = rate;
	}
	
	public void Display_details() {
		System.out.println("pricipal amount $:"+principal);
		System.out.println("interest rate:"+rate);
		System.out.println("the time period is:"+time);
	}
}

class Simple_Interest extends Investment_Details{
	public Simple_Interest(double principal,int time, double rate) {
		super(principal,time,rate);
	}
	
	public double Calculate_SI() {
		return (principal*rate*time)/100;
	}
}

class Compound_Interest extends Investment_Details{
	private int frequencycompound;
	public Compound_Interest(double pricipal,int time, double rate, int frequencycompound) {
		super(pricipal,time,rate);
		this.frequencycompound = frequencycompound;
	}
	
	public double Calculate_CI() {
//		return principal * Math.pow((1 + rate / (100 * frequencycompound)), frequencycompound * time);
		return principal * Math.pow((1 + rate / (100 * frequencycompound)), frequencycompound * time) - principal;

	}
}

public class Investment {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Principal amount $:");
		double principal = in.nextInt();
		
		System.out.println("Enter The Nummber of Years");
		int time = in.nextInt();
		
		System.out.println("Enter the interest Rate");
		double rate = in.nextDouble();
		
		System.out.println("Enter the type of investment (1:Simple Interest, 2:Compound Interest)");
		int Choice = in.nextInt();
		
		if(Choice ==1) {
			Simple_Interest si = new Simple_Interest(principal,time,rate);
			System.out.println("return amount:"+si.Calculate_SI());
		}
		else if(Choice == 2) {
			System.out.println("Enter the tenure (annual =1, daily = 365, monthly 12:");
			int tenure = in.nextInt();
			Compound_Interest ci = new Compound_Interest(principal,time,rate,tenure);
			System.out.println("The Interest rate is :$"+ci.Calculate_CI());
		}
	}

}
