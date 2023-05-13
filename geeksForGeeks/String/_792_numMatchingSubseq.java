package String;

public class _792_numMatchingSubseq {

	public static void main(String[] args) {

		String s = "abcde";
		String[] words = {"a","bb","acd","ace"};
		
		/*
		 * 
		 * method 1:
		 * find subsequence for a words[i] against s.
		 * if any subsequence , count++
		 * tc : words * s
		 * 
		 * 
		 * method 2: (inverted index)
		 * 
		 * use appropriate data structure to store index based on prb requirement
	        s = abcde , w = ["a","bb","acd","ace"]
	        [0](a) -> [a,acd,ace]
	        [1](b) -> [bb]
	        [2](c) -> 
	        [3](d) ->
	        [4](e) ->
	        
	        traverse s string, remove the 1st character 
	        and insert rest of word in corresponding index(start char of word)
	        eg:
			[0](a) -> 
	        [1](b) -> [bb]
	        [2](c) -> [_,_cd,_ce]
	        [3](d) ->
	        [4](e) ->

		*/
		
		

		
	}

}
