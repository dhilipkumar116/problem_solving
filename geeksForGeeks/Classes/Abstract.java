package Classes;


abstract class version1{
	
	public void callFeature() {
		System.out.println("v1 has Call Feature");
	}
	public abstract void MessageFeature();
	public abstract void CameraFeature();
	public abstract void InternetFeature();
}

abstract class version2 extends version1{
	public void MessageFeature() {
		System.out.println("v2 has Message Feature");
	}
}
abstract class version3 extends version2{
	public void CameraFeature() {
		System.out.println("v3 has Camera Feature");
	}
}

// concrete class , we has implemented all abstract methods
class version4 extends version3{
	public void InternetFeature() {
		System.out.println("v4 has Internet Feature");
	}
}

public class Abstract {

	public static void main(String[] args) {		
		version1 v = new version4();
		v.callFeature();
		v.CameraFeature();
		v.InternetFeature();
		v.MessageFeature();
	}

}
