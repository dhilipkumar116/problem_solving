package dp;

import java.util.*;


public class KnapSack0_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            pq.add(sc.nextInt());
        }
        int k = sc.nextInt();
        
        int[] result = new int[k];
        int i=0;
        while(i!=k){
            result[i++] = pq.poll();
        }
        for(int res:result){
            System.out.print(res+" ");
        }
		
	}

}
