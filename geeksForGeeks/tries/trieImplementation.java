package tries;

import java.util.HashMap;
import java.util.Map;



public class trieImplementation {
	
	
	class TrieNode{
		Map<Character,TrieNode> children;
		boolean isEndOfWord; 
		TrieNode(){
			children = new HashMap<>();
			isEndOfWord = false;
		}
	}
	
	private static TrieNode root;
	public trieImplementation() {
		root =  new TrieNode();
	}
	
	private void insert(String word) {
		TrieNode current = root;
		for(int i=0;i<word.length();i++) {
			char cur = word.charAt(i);
			TrieNode node = current.children.get(cur);
			if(node==null) {
				node = new TrieNode();
				current.children.put(cur, node);
				current = current.children.get(cur);
				continue;
			}
			current=node;
		}
		current.isEndOfWord=true;
	}
	private void insertRecursive(TrieNode current,String word,int index) {
		
		if(index>=word.length()) {return;}
		
		char cur = word.charAt(index);
		TrieNode node = current.children.get(cur);
		if(node==null) {
			node = new TrieNode();
			current.children.put(cur, node);		
		}
		current=node;
		insertRecursive(current,word,index+1);
		current.isEndOfWord=true;
		
	}


	private boolean searchWord(String word) {
		
		TrieNode current = root;
		for(int i=0;i<word.length();i++) {
			char cur = word.charAt(i);
			TrieNode node = current.children.get(cur);
			if(node==null) {
				return false;
			}
			current = node;
		}
		return current.isEndOfWord;
		
	}
	
	private boolean searchRecursive(String word,int index,TrieNode current) {
		
		if(word.length()==index) {return current.isEndOfWord;}
		
		char cur = word.charAt(index);
		TrieNode node = current.children.get(cur);
		if(node==null) {
			return false;
		}
		return searchRecursive(word,index+1,node);
		
	}
	
	private boolean delete(String word,int index,TrieNode current) {
		if(index==word.length()) {
			if(!current.isEndOfWord) {
				return false;
			}
			current.isEndOfWord=false;
			return current.children.size()==0;
		}
		char cur = word.charAt(index);
		TrieNode node  = current.children.get(cur);
		if(node==null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(word,index+1,node);
		if(shouldDeleteCurrentNode) {
			current.children.remove(cur);
			return current.children.size()==0;
		}
		return false;
	}
	
	public static void main(String[] args) {

		trieImplementation trie = new trieImplementation();
		String[] words =  {"abc","abgl","cdf","abcd","lmn"};
//		for(String word:words) {
//			trie.insert(word);
//		}
//		
		for(String word:words) {
			trie.insertRecursive(root,word,0);
		}
		
		System.out.println(trie.searchWord(words[0]));
		System.out.println(trie.searchRecursive(words[0],0,root));
		
		System.out.println(trie.delete(words[4],0,root));
		
	}

}
