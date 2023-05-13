package strings;
import java.util.*;

public class paranthesesChecking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "()[]{}]";
		
		System.out.println(check(s));

	}
	
	static boolean check(String s) {
		
		
		Stack<Character> stack = new Stack<Character>();
		char[] str = s.toCharArray();
		for(Character c : str) {
			if(c=='('||c=='{'|| c=='[') {
				stack.push(c);
			}else {
				if(c==')') {
					if(stack.size()==0||stack.pop()!='(') return false;
				}
				if(c=='}') {
					if(stack.size()==0||stack.pop()!='{') return false;
				}
				if(c==']') {
					if(stack.size()==0||stack.pop()!='[') return false;
				}
			}
				
		}
		return true;
	}

}
