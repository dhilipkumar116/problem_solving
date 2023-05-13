package serialization.serial;

import java.io.*;


public class Persist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new Student(1,"dhilip");
		Student s2 = new Student(2,"kumar");
		
		
		try {
			
			FileOutputStream fout = new FileOutputStream("data.txt");
			ObjectOutputStream objOut = new ObjectOutputStream(fout);
			objOut.writeObject(s1);
			objOut.writeObject(s2);
			objOut.flush();
			objOut.close();
			System.out.print("success...");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
