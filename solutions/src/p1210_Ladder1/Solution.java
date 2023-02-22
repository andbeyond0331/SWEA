package p1210_Ladder1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			int tc = Integer.parseInt(br.readLine());
			
			int[][] ladder = new int[100][100];
			StringTokenizer st;
			int x = 0; // 도착점 x 좌표
			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < ladder.length; k++) {
					ladder[j][k] = Integer.parseInt(st.nextToken());
					if(ladder[j][k]==2) {
						x = k;
					}
				}
			}
			
			int curR = 99;
			int curC = x;
			while(curR>0) {
				// 위로 하나씩 올라가는데 왼쪽에 1이면 curC-1, 오른쪽이 1이면 curC+1
//				curR--;
				if(curC-1>0 && ladder[curR][curC-1] == 1) {
					while(ladder[curR][curC]==1) {
						curC--;
						if(curC<0) {
							break;
						}
						
					}
					curC++;
				}else if(curC+1<ladder.length && ladder[curR][curC+1] == 1) {
					while(ladder[curR][curC]==1) {
						curC++;
						if(curC>ladder.length-1) {
							break;
						}
					}
					curC--;
				}
				curR--;
			}
			System.out.printf("#%d %d\n", tc, curC);
			
			
			
			
			
		}
	}
}
