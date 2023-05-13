package String;

public class rabinKarpAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		idea is to create hashing for pattern and string of equal length of pattern
//		if both hash matches, we can conclude pattern present in string. 
		
		String s = "abdaasdfabc";
		String pattern = "abc";
		int mod=3;
		int hashP = getHash(pattern,mod);
		
		int start=0;
		int hashS=0;
		int a=0;
		for(int i=0;i<s.length();i++) {
			char cur = s.charAt(i);

			if(i>=pattern.length()) {
				hashS -=s.charAt(start++);
				hashS =hashS/mod;
				hashS +=cur*Math.pow(mod, pattern.length()-1);
			}else {
				hashS +=cur*Math.pow(mod, a++);
			}
			
			if(hashP==hashS) {
				System.out.println(s.substring(start,start+pattern.length()));
				break;
			}
			
		
		}
		
	}
	
	public static String getResult(String p,String s) {
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)!=s.charAt(i)) {
				return "pattern not matched";
			}
		}
		return "pattern matched";
	}
	
	public static int getHash(String str,int mod) {
		int hash=0;
		int i=0;
		for(char ch:str.toCharArray()) {
			hash +=ch*Math.pow(mod, i);
			i++;
		}
		return hash;
	}

}
