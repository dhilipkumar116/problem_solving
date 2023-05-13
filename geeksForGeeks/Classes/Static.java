package Classes;

class Bank{
	private static String BName = "SBI";
	public static class BankName{
		public void displayName() {
			System.out.println("my bank name is : "+BName);
		}
	}
}

public class Static {
	public static void main(String[] args) {

		Bank.BankName bn = new Bank.BankName();
		bn.displayName();//accessing methods inside static class
	
	}

}
