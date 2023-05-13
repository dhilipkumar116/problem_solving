package String;
import java.util.*;

public class _1055_shortest_way_to_form_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_1055_shortest_way_to_form_string sw = new _1055_shortest_way_to_form_string();
		System.out.println(sw.shortestWay("abcab", "aabbaac"));
			
	}
	
	
	public int shortestWay(String source, String target) {
		char[] cs = source.toCharArray(), ts = target.toCharArray();
		int res = 1;
		List<Integer>[] idx = new List[26];
		for (int i = 0; i < 26; i++) idx[i] = new ArrayList<>();
		for (int i = 0; i < cs.length; i++) idx[cs[i] - 'a'].add(i);
		int j = 0;
		for (int i = 0; i < ts.length; ) {
			List<Integer> tar = idx[ts[i] - 'a'];
			if (tar.isEmpty()) return -1;
			int k = Collections.binarySearch(tar,j);
			if (k < 0) k = -k - 1;
			if (k == tar.size()) {
				res++;
				j = 0;
			} else {
				j = tar.get(k) + 1;
				i++;
			}

		}
		return res;
	}

}
