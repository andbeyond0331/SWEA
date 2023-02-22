package p1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N==1) {
			System.out.println(0);
		}else {
			int[] dp = new int[N+1];
		
		dp[2] = 1;
		
		
		for(int i = 3; i <= N; i++) {
			if(dp[i-1] != 0) {
				dp[i] = dp[i-1]+1;
			}
			if(i%3==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			if(i%2==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
		}
		
		System.out.println(dp[N]);
		
		}
		
		
		
	}
}
