package p1149_RGB거리_unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_시간초과버전 {
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[][] colors;
//	static int[] expenses;
//	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 집이 몇 채야?(2<=N<=1000)
		StringTokenizer st;
		
		colors = new int[N][3];
//		expenses = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); 
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			colors[i][0] = r;
			colors[i][1] = g;
			colors[i][2] = b;
			
		}
//		expenses[0] = Math.min(Math.min(colors[0][0], colors[0][1]), colors[0][2]);
		for(int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				
				if(i!=j) {
//					System.out.println("i: " + i + ", j: " + j);
//					if(expenses[1]==0) {
//						expenses[1] = expenses[0] + colors[1][j];
//					}
//					color(i, j, 1, Math.min(expenses[1], expenses[0]+colors[1][j]));
					color(i, j, 1, colors[0][i] + colors[1][j]);
				}
			}
		}
		
		System.out.println(min);
		
		
	}
	
	static void color(int f, int s, int n, int pay) { // 이전전 색, 이전 색, 몇 번 째 집, 쌓인 비용
		
//		if(expenses[n]==0) {
//			expenses[n] = expenses[n-1]+colors[n][s];
//		}else {
//			expenses[n] = Math.min(expenses[n], expenses[n-1]+colors[n][s]);
//		}
		if(n==N-1) {
			min = Math.min(min, pay);
			return;
		}
		
//		color(s, 3-(f+s), n+1, expenses[n]+colors[n+1][3-(f+s)]);
//		color(s, f, n+1, expenses[n]+colors[n+1][f]);
		color(s, 3-(f+s), n+1, pay+colors[n+1][3-(f+s)]);
		color(s, f, n+1, pay+colors[n+1][f]);
	}
}
