package Classes;

/*
 1)Once a variable, method or a class is declared as final,
it’s value remains the same throughout. 
2)The final keyword in a method declaration indicates 
that the method cannot be overridden by any subclasses
i.e., a class that has been declared
final cannot be subclassed. 
3)This helps a lot while creating an immutable 
class like the String class. 
4)A class cannot make a class immutable without making it final.*/


final class BaseClass{
	void display() {
		System.out.println("base class");
	}
}

class DerivedClass extends BaseClass{
	void display() {
		System.out.println("derived class");
	}
}


public class Final {
	public static void main(String[] args) {
		DerivedClass d = new DerivedClass();
		d.display();
	}
}
