package Classes;

public class POJO {
//	plain old java objects - pojo
	
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.getName());
	}

}
class Test{
	private String name="dhilip";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}