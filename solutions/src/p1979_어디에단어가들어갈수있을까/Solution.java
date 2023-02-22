package p1979_어디에단어가들어갈수있을까;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				StringTokenizer line = new StringTokenizer(br.readLine(), " ");
				for(int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(line.nextToken());
				}
			}
			
			int count = 0;
			
			// 가로 탐색
			for(int x = 0; x < N; x++) {
				int sum = 0;
				for(int y = 0; y < N; y++) {
//					if(y==N-1) {
//						if(sum==K) {
//							count++;
//							break;
//						}
//					}
					if(board[x][y] == 0) {
						if(sum==K) {
							count++;
							sum=0;
						}else {
							sum=0;
						}
					}else {
						sum++;
						if(y==N-1) {
							if(sum==K) {
								count++;
							}
						}
					}
				}
			}
			
			// 세로 탐색
			for(int x = 0; x < N; x++) {
				int sum = 0;
				for(int y = 0; y < N; y++) {
//					if(y==N-1) {
//						if(board[y][x]==0) {
//							
//						}
//						if(sum==K) {
//							count++;
//							break;
//						}
//					}
					if(board[y][x] == 0) {
						if(sum==K) {
							count++;
							sum=0;
						}else {
							sum=0;
						}
					}else {
						sum++;
						if(y==N-1) {
							if(sum==K) {
								count++;
							}
						}
					}
				}
			}
			
			System.out.println("#" + test + " " + count);
		}
	}
}
