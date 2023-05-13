package strings;

public class multiplyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String num1 = "213",num2="43";
		if(num1.equals("0")||num2.equals("0"))
				System.out.println("0");;
        
        int pos1,pos2,product;
        int size1 = num1.length()-1;
        int size2 = num2.length()-1;
        // result will be double the length of number
        int[] result = new int[size1+size2+2];
        
        // it does ordinary multiplication 
        for(int i=size1;i>=0;i--){
            int c1 = Character.getNumericValue(num1.charAt(i));
            for(int j=size2;j>=0;j--){
                int c2 = Character.getNumericValue(num2.charAt(j));
                pos1 = i+j+1;
                pos2 = i+j;
                product = c1*c2;
                //if product is two digit number store the last value in pos1 and 1st digit in pos2  
                result[pos1] += product%10;
                result[pos2] +=product/10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = result.length-1 ; i >= 0; --i){
        	
        	// in some case there will be 0 in 0th index to avoid that continue..
            if (i == 0 && result[i] == 0)
                continue;
            sb.append(result[i] % 10);
            //if value is greater than 10..append the last digit and sum the 1st number with previous index value
            if (result[i] >= 10){
                result[i-1] += result[i] / 10;
            }
        }
        System.out.println(sb.reverse().toString());

	}

}
