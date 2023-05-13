package thread;

public class CallingRunMethodDirectly {

	public static void main(String[] args) {

		
		TestCall t1 = new TestCall();
		TestCall t2 = new TestCall();
//		t1.start();
//		t2.start();
		// each thread will create their own call stack
		
		
		t1.run();
		t2.run();
		// place the thread into main thread call stack
		// rather than creating new call stack on own
		// so no content switching bcoz here t1, t2 are treated as normal object not thread objects
	}

}

class TestCall extends Thread{
	public void run() {
		
		for(int i=1;i<=5;i++) {
			System.out.print(i+" ");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}
}
