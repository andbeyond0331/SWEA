package p1206_1일차_View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] buildings = new int[N];
			int[][] height = new int[1000][256];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			
//			System.out.println(Arrays.toString(buildings));
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < 256; j++) {
					if(j<buildings[i]) {
						height[i][j] = 1;
					}else { break; };
					
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < 256; j++) {
					if(height[i][j] > 0) {
						if(height[i-2][j]==0 && height[i-1][j]==0 && height[i+1][j]==0 && height[i+2][j]==0) {
							cnt++;
						}
					}
				}
			}

			
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
