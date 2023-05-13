package thread;

public class JoinMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JoinMethod1 t1 = new JoinMethod1();
		JoinMethod1 t2 = new JoinMethod1();
		JoinMethod1 t3 = new JoinMethod1();
		
		t1.start();
		try {
			t1.join(); // when t1 completes its task then t2 and t3 starts executing.
//			t1.join(2000); // when t1 is completes its task for 2000 miliseconds(3 times) then t2 and t3 starts executing.
		}catch(Exception e) {}
		
		t2.start();
		t3.start();
		
		
	}

}

class JoinMethod1 extends Thread{
	public void run() {
		System.out.print(Thread.currentThread().getName()+":");
		for(int i=1;i<=5;i++) {
			System.out.print(i+" ");
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
	}
}
