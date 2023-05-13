package strings;

public class stringDivideByString {

	public static void main(String[] args) {
		
		//if tSubString matches with s string return the length of t substring.
		String s = "abcabc";
		String t = "abc";
		getResult(s,t);
		System.out.println(getResultIte(s,t));

	}
	
	
	// idea : we moving the tstring one by one ,
	// replace the tsubString with ""(empty space) in s string if s.length()==0 it matches exactly. 
	static void getResult(String s,String t) {
		for(int i=0;i<t.length();i++) {
			String tSub = t.substring(0, i+1);
			System.out.println(tSub);
			String res = s.replaceAll(tSub, "");
			if(res.length()==0) {
				System.out.println(i+1);
				break;
			}
		}
	}
	
	
	//brute force 
	static int getResultIte(String s,String t) {
			
		for(int i=0;i<t.length();i++) {
			int count = 0;
			String tSub = t.substring(0,i+1);
			for(int j=0;i<s.length();j=j+i+1) {
				String sSub = s.substring(j,j+i+1);
				if(sSub.equals(tSub)) {
					count++;
					if(j+i==s.length()-1) {
						return i+1;
					}
				}else {
					break;
				}
			}
		}
		return -1;
	}

}



























