package p1961_숫자배열회전;

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
			
			int[][] board = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				StringTokenizer line = new StringTokenizer(br.readLine(), " ");
				for(int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(line.nextToken());
				}
			}
			
			int[][] one = new int[N][N];
			int[][] two = new int[N][N];
			int[][] three = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					one[r][c] = board[N-1-c][r];
					
				}
			}
			
//			for (int i = 0; i < three.length; i++) {
//				for (int j = 0; j < three.length; j++) {
//					System.out.print(one[i][j]);
//				}
//				System.out.println();
//			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) { 
					two[r][c] = board[N-1-r][N-1-c];
				}
			}

//			for (int i = 0; i < three.length; i++) {
//				for (int j = 0; j < three.length; j++) {
//					System.out.print(two[i][j]);
//				}
//				System.out.println();
//			}
//			
//			
//			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) { 
					three[r][c] = board[c][N-1-r];
				}
			}
			
//			for (int i = 0; i < three.length; i++) {
//				for (int j = 0; j < three.length; j++) {
//					System.out.print(three[i][j]);
//				}
//				System.out.println();
//			}
			
			String result = "";
			
			for(int i = 0; i < three.length; i ++) {
				for(int j = 0; j < one.length; j ++) {
					result+=one[i][j];
				}
				result+=" ";
				
				for(int j = 0; j < one.length; j ++) {
					result+=two[i][j];
				}
				result+=" ";
				
				for(int j = 0; j < one.length; j ++) {
					result+=three[i][j];
				}
				result+="\n";
				
			}
			
			
			
			
			System.out.print("#" + test + "\n" + result);
		}
	}
}
