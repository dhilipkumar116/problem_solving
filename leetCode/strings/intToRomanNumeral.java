package strings;

import java.util.TreeMap;

public class intToRomanNumeral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			int num = 928;
		
		  	TreeMap<Integer,String> map = new TreeMap<Integer,String>();
	        map.put(1,"I");
	        map.put(4,"IV");
	        map.put(5,"V");
	        map.put(9,"XI");
	        map.put(10,"X");
	        map.put(40,"XL");
	        map.put(50,"L");
	        map.put(90,"XC");
	        map.put(100,"C");
	        map.put(400,"CD");
	        map.put(500,"D");
	        map.put(900,"CM");
	        map.put(1000,"M");
	       
	        //using TreeMap
	        System.out.println(findNumber(num,map));
	        //using looping
	        looping(num);

	}
	
	static String findNumber(int num,TreeMap<Integer,String> map) {
		//floorKey and ceilingKey is available only in TreeMap
		 int currNum = map.floorKey(num);
	        if(num==currNum){
	            return map.get(currNum);
	        }
	        return map.get(currNum)+findNumber(num-currNum,map);
	}
	
	static void looping(int num) {
		int[] romanNumber = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] romanNumerals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		String result = "";
		for(int i=0;i<romanNumber.length;i++) {
			
			int noOfTime = num/romanNumber[i];
			while(noOfTime>0) {
				result=result+romanNumerals[i];
				noOfTime--;
			}
			num=num%romanNumber[i];
		}
		System.out.println(result);
	}

}
