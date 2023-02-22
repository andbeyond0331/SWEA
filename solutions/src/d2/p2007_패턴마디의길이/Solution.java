package d2.p2007_패턴마디의길이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int result = 0;
			for (int i = 1; i <= 10; i++) {
				String tmp = str.substring(0,i);
				int cnt = 1;
				for (int j = i; j <= str.length()-i; j+=i) {
					if(!tmp.equals(str.substring(j, j+i))) {
						break;
					}else {
						cnt++;
					}
				}
				if(cnt  == str.length()/(i)) {
					result = i;
					break;
				}
				
				
				
			}
			
			
			System.out.printf("#%d %d\n", tc, result);
		}
		
	}
}
