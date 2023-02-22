package p1220_Magnetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test = 1; test <= 10; test++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] bo = new int[100][100];
			
			for(int r = 0; r < 100; r++) {
				StringTokenizer st =new StringTokenizer(br.readLine(), " ");
				
				for(int c = 0; c < 100; c++) {
					bo[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1은 N, 2는 S
			// 위는 N, 아래는  S
			int cnt = 0;
			for(int c = 0; c < 100; c++) {
				
				int sta = 0;
				for(int r = 0; r < 100; r++) {
					if(bo[r][c]!=0) {
						
					}
				}
			}
//			System.out.println("#" + test + " " + plus );
		}
			
			
			
			
	
	}
}
