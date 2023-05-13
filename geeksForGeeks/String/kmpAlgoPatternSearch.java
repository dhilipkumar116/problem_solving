package String;

public class kmpAlgoPatternSearch {

	private void bruteForce() {

		String s="abcdcglx";
		String p="dcgl";
		
		int j=0;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c==p.charAt(j)) {
				j++;
			}else if(c!=p.charAt(j)) {
				while(j>0) {
					if(c==p.charAt(j--)) {
						break;
					}
				}
			}
			
			if(j==p.length()) {
				System.out.print("match found");
				break;
			}
		}
	}
	
	public void kmpAlgo() {
		String s = "abxabcabcaby";
		String p = "abcaby";
		//longest prefix suffix
		int[] lps = new int[p.length()];
		int j=0;
		int i=1;
		while(i<p.length()) {
			if(p.charAt(j)==p.charAt(i)) {
				lps[i]=j+1;
				j++;
				i++;
			}else {
				if(j==0) {
					lps[i]=0;
					i++;
				}else {
					j=lps[j-1];
				}
			}
		}
//		for(int n:lps) {
//			System.out.print(n+" ");
//		}
		
		int k=0;
		int cur=0;
		while(cur<s.length()) {
			if(s.charAt(cur)==p.charAt(k)) {
				cur++;
				k++;
			}else {
				if(k==0) {cur++;}
				else {
					k=lps[k-1];
				}
			}
			if(k==p.length()) {
				System.out.print("match found");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		kmpAlgoPatternSearch kmp = new kmpAlgoPatternSearch();
		//kmp.bruteForce();
		kmp.kmpAlgo();
		
	}

}
