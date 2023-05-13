package serialization.serial;

import java.io.*;

public class DePersist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			FileInputStream fin = new FileInputStream("data.txt");
			ObjectInputStream objIn = new ObjectInputStream(fin);
			Student s = (Student)objIn.readObject();
			Student s1 = (Student)objIn.readObject();

			System.out.println(s.id+" "+s.name);
			System.out.println(s1.id+" "+s1.name);

			objIn.close();
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
