package p2001_파리퇴치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				StringTokenizer str = new StringTokenizer(br.readLine(), " ");
				for(int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(str.nextToken());
				}
			}
			
			int max = -1;
			
			for(int x = 0; x <= N-M; x++) {
				for(int y = 0; y <= N-M; y++) {
					int sum = 0;
					
					for(int r = 0; r <M; r++) {
						for(int c = 0; c < M; c++) {
							sum+=board[x+r][y+c];
						}
					}
					if(max<sum) {
						max = sum;
					}
				}
				
			}
			
			System.out.println("#" + test + " " + max);
		}
		
	}
}
