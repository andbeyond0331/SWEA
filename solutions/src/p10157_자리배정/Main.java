package p10157_자리배정;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		int[][] hall = new int[R][C];
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		int r = 0;
		int c = 0;
		
		
		int num = 1;
		hall[r][c] = num++;
		int pointer = 0;
		
		if(K > R*C) {
			sb.append(0);
		}else {
			while(num<=K) {
				int nr = r+dr[pointer];
				int nc = c+dc[pointer];
				if(nr>=0 && nc>=0 && nr<=R-1 && nc<=C-1 && hall[nr][nc]==0) {
					r = nr;
					c = nc;
					hall[nr][nc] = num++;
				}else {
					pointer = pointer+1==4? 0: pointer+1;				
				}
			}
			
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(hall[i][j]+ " ");
//				}
//				System.out.println();
//			}
			r = r+1;
			c = c+1;
			
			sb.append(r);
			sb.append(" ");
			sb.append(c);
		}
		
		
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
