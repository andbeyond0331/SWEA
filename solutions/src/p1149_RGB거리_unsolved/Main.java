package p1149_RGB거리_unsolved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[][] colors;
	static int[] expenses;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
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
		color(1);
		
		System.out.println(min);
		
		
	}
	
	static void color(int n) { // 몇 번 째 집
		
		colors[n][0] += Math.min(colors[n-1][1], colors[n-1][2]);
		colors[n][1] += Math.min(colors[n-1][0], colors[n-1][2]);
		colors[n][2] += Math.min(colors[n-1][0], colors[n-1][1]);
		
		if(n==N-1) {
			min = Math.min(Math.min(colors[n][0], colors[n][1]), colors[n][2]);
			return;
		}else {
			color(n+1);
		}
	}
}
