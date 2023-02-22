package p1209_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			int tc = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];
			StringTokenizer st;
			int sum = 0;
			int x1 = 0;
			int x2 = 0;
			for (int j = 0; j < arr.length; j++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				int tempSum= 0;
				for (int k = 0; k < arr.length; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					tempSum+=arr[j][k];
					if(j==k) {
						x1+=arr[j][k];
					}
					if(j+k==arr.length-1) {
						x2+=arr[j][k];
					}
					
				}
				sum = Math.max(tempSum, sum);
			}
			for (int j = 0; j < arr.length; j++) {
				int tempSum = 0;
				for (int k = 0; k < arr.length; k++) {
					tempSum+=arr[k][j];
				}
				sum = Math.max(sum, tempSum);
			}
			sum = Math.max(Math.max(x1, x2), sum);
			
			System.out.printf("#%d %d\n", tc, sum);
			
			// 대각선 합
		}
	}
}
