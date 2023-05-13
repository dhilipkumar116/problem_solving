package arrays;

public class catalanNumber {

	public static void main(String[] args) {
	
		//application
		// we can count no of possible bst with n-key
		// we can count no of full binary tree(fbs) with n+1 leaves
		
		
		//c0=c1=1
		//c2 = c0c1+c1c0
		//c3 = c0c2+c1c1+c2c0
		//general form = c(n)=c0c(n-1).....c(i)c(n-i-1)......c(n-1)c0.
		
		int n=4;
		bruteForce(n);
		System.out.print("recursive solution : ");
		System.out.print(recursion(n));
		dynamic(n);
	
	}
	
	static void bruteForce(int n) {
		int[] cat = new int[n+1];
		cat[0]=1;
		cat[1]=1;
		for(int j=2;j<=n;j++) {
			int newCat=0;int k=0;
			for(int i=j-1;i>=0;i--) {
					newCat +=(cat[k]*cat[i]);
					k++;
			}
			cat[k]=newCat;		
		}
		for(int a:cat)
			System.out.print(a+" ");
		System.out.println();

	}
	
	// exponential time complexity
	static int recursion(int n) {
		if(n==1||n==0) return 1;		
		int result=0;
		for(int i=0;i<n;i++) {
			result +=recursion(i)*recursion(n-i-1);
		}
		return result;
	}
	// 0(n square)
	static void dynamic(int n) {
		int[] c = new int[n+1];
		c[1]=c[0]=1;
		for(int i=2;i<=n;i++) {
			c[i]=0;
			for(int j=0;j<i;j++) {
				c[i] += c[j]*c[i-j-1];
			}
		}
		
		System.out.println();
		System.out.print("dynamic : "+c[n]);
	}

}























