package Classes;

class outer{
	
	void outerMethod() {
		System.out.println("this is outer method");
		//inner class is local to outerMethod
		class inner{
			void innerMethod() {
				System.out.println("this is inner method");
			}
			
		}
		inner in = new inner();
		in.innerMethod();
	}
	
}

public class MethodLocalInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		outer o = new outer();
		o.outerMethod();
	}

}
