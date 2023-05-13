package thread;

import java.util.Scanner;

public class InterThreadComm {

	public static void main(String[] args) {

		Customer c = new Customer(1000);
		Thread t1 = new Thread() {
			public void run() {
				c.withdraw(1500);
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				c.deposite();
			}
		};
		
		t1.start();
		t2.start();
		
			
	}

}


class Customer{
	int amount=0;
	
	Customer(int amount) {
		this.amount = amount;
	}
	
	synchronized void withdraw(int amount) {
		System.out.println("entering withdraw ...");
		if(this.amount<amount) {
			System.out.println("balance is low...");
			try {
				wait();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		this.amount -=amount;
		System.out.println("withdraw completed...");
	}
	
	synchronized void deposite() {
		System.out.println("entering deposit...");

		
		System.out.println("enter your deposit amount");
		Scanner sc  = new Scanner(System.in);
		int amount = sc.nextInt();
		sc.close();
		
		this.amount +=amount;
		System.out.println("deposit completed...");
		notify();
	}
	
	
}