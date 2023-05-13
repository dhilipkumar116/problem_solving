package arrays;

public class towerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		there will be 3 towers with n no of discs
//		we need to move all discs to last tower.
//		
//		move (n-1)discs from A to B using C
//		move a disc from A to C
//		move (n-1)discs from B to C using A
		
		towerOfHanoi(3,1,2,3);
	}
	
	public static void towerOfHanoi(int n,int A,int B,int C) {
		if(n>0) {
			towerOfHanoi(n-1,A,C,B);
			System.out.println("moving disc from "+A+" to "+C);
			towerOfHanoi(n-1,B,A,C);
		}
	}

}
