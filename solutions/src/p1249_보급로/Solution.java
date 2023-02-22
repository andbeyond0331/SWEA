package p1249_보급로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				String st = br.readLine();
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.substring(j,j+1));
				}
			}
		
			
			// 여기까지 배열에 저장
			
			int lt = 0; // 최소 이동 시간
			
			int[][] dp = new int[N][N];
			
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j++) {
					if(i!=0) {
						if(j!=0) {
							dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+arr[i][j];
						}else {
							dp[i][j] = dp[i-1][j] + arr[i][j];
						}
					}else {
						if(j!=0) {
							dp[i][j] = dp[i][j-1] + arr[i][j];
						}else {
							dp[i][j] = arr[i][j];
						}
					}
				}
			}
			if(tc==1) {
				for (int i = 0; i < dp.length; i++) {
					for (int j = 0; j < dp.length; j++) {
						System.out.printf("%-5d", dp[i][j]);
					}
					System.out.println();
				}
				
				for (int i = 0; i < dp.length; i++) {
					for (int j = 0; j < dp.length; j++) {
						System.out.printf("%-5d", arr[i][j]);
					}
					System.out.println();
				}
				
			}
		
			
			System.out.println("#"+tc+" "+dp[N-1][N-1]);
		}
	}
}
