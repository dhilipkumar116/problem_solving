package trees;


public class insertionusingArray {
	
	static int root=0;
	static String[] str = new String[10];
	
	static void root(String value) {
		str[0]=value;
	}
	
	static void addLeft(String value , int root)
	{
		if(str[root]==null)
			System.out.println("no such root is present");
		else {
			str[(2*root)+1]=value;
		}
	}
	
	static void addRight(String value,int root)
	{
		if(str[root]==null)
			System.out.println("no such root is present");
		else {
			str[(2*root)+2]=value;
		}
	}
	
	
	static void print() {
		
		if(str[0]==null)
			System.out.print("tree is empty");
		
		for(int i=0;i<10;i++) {
			if(str[i]==null)
				System.out.print("-");
			else
				System.out.print(str[i]);
		}
	}

	public static void main(String[] args) {
		
		
		root("A");
		addLeft("B",0);
		addRight("C",0);
		addLeft("D",1);
		addRight("E",2);
		print();

	}

}




















