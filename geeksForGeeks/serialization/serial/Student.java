package serialization.serial;

import java.io.Serializable;

public class Student implements Serializable {
	
	//optional
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	public Student(int id,String name) {
		this.id = id;
		this.name = name;
	}

}
