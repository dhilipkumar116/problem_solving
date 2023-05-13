package Classes;


class YourName{
	void display() {
		System.out.println("my name is dhilip - from class");
	}
}

public class AnonymousInnerClass {

	public static void main(String[] args) {
	
		
		// anonymous class is class which as no name
		YourName yn = new YourName()
				{//class start with {} ,
				 //no name for this class
					void display() {
						super.display();
						System.out.println("my name is dhilip - from anonymous class");
					}
				};
		yn.display();

	}

}
