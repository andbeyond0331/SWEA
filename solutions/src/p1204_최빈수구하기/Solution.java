package p1204_최빈수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int tc = Integer.parseInt(br.readLine());
			
			StringTokenizer st =new StringTokenizer(br.readLine(), " ");
			int[] students = new int[1000];
			int[] scores = new int[101];
			int maxCnt = 0;
			int max = 0;
			for (int j = 0; j < students.length; j++) {
				students[i] = Integer.parseInt(st.nextToken());
				scores[students[i]]++;
				if(scores[students[i]]>=maxCnt) {
					maxCnt = scores[students[i]];
					max = students[i];
				}
			}
			System.out.printf("#%d %d\n", tc, max);
			
			
		}
	}
}
