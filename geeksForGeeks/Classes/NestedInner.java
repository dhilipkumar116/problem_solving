package Classes;

class Outer { 
	   // Simple nested inner class 
	   class Inner { 
	      public void show() { 
	           System.out.println("This is inside a nested class method "); 
	      } 
	   } 
}

public class NestedInner { 
   public static void main(String[] args) { 
       Outer.Inner in = new Outer().new Inner(); 
       in.show(); 
   } 
} 


