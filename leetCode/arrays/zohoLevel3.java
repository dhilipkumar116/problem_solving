package arrays;
import java.util.*;

public class zohoLevel3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.printf("%-20s%s%n","customerId","balance");
		Customers c1 = new Customers(1,10000);
		Customers c2 = new Customers(2,20000);
		Customers c3 = new Customers(3,30000);
		System.out.println();
		System.out.printf("%-10s%10s%10s%15s%10s%n","cardNo","custId","PIN","Gcard bal","status");
		c1.giftCard(1,1,1111,2500,true);
		c1.giftCard(2,1,2222,2500,true);
		c2.giftCard(3,2,3333,5000,true);
		c3.giftCard(4,3,1234,0,false);
		System.out.println();
		System.out.println("Account Summary");
		System.out.printf("%-20s%s%n","customerId","balance");
		c1.AccountSummary();
		c2.AccountSummary();
		c3.AccountSummary();
		System.out.println();
		System.out.println("do u want to TOP-UP gift card(y/n)?");
		String topup = sc.next();
		if(topup.equals("y")) {
			c1.topup(3, 2500);
			System.out.println();
			System.out.println("Gift card summary");
			System.out.printf("%-10s%10s%10s%15s%10s%n","cardNo","custId","PIN","Gcard bal","status");
			c1.GiftCardSummary();
		}
		System.out.println();
		System.out.println("do u want to CLOSE card(y/n)?");

		
		
	}

}


class Customers{
	int customerId,balance;
	Customers(int coId,int bal){
		customerId = coId;
		balance = bal;
		System.out.printf("%-20d%d%n",customerId,balance);
	}
	
	void AccountSummary() {
		System.out.printf("%-20d%d%n",customerId,balance);
	}
	
	int cNo,cusId,pin,Gbalance;
	boolean status;
	String active;
	void giftCard(int cNo,int cusId,int pin,int Gbalance,boolean status) {
		this.cNo = cNo;
		this.cusId = cusId;
		this.pin = pin;
		this.Gbalance =  Gbalance;
		this.status = status;
		
		if(status) {
			active="active";
		}else {
			active ="closed";
		}
		
		if(balance-Gbalance>=0) {
			balance -=Gbalance;
			System.out.printf("%-10d%10d%10d%15d%10s%n",cNo,cusId,pin,Gbalance,(status)?"active":"closed");
			
		}else {
			System.out.println("customerId : "+cusId+" - has insufficient balance");
		}
	}
	
	void topup(int cardNo,int amount) {
		if(balance-amount>=0) {
			Gbalance +=amount;
		}
	}
	void GiftCardSummary() {
		System.out.printf("%-10d%10d%10d%15d%10s%n",cNo,cusId,pin,Gbalance,(status)?"active":"closed");
	}
	 
}
