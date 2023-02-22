package p12712_파리퇴치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < T; test++) { // 테스트케이스만큼 돌리기
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); //N과 M 받기
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] bo = new int[N][N]; 
			for(int r = 0; r < N; r++) {
				StringTokenizer rs = new StringTokenizer(br.readLine(), " ");
				for(int c = 0; c < N; c ++) {
					bo[r][c] = Integer.parseInt(rs.nextToken());
				}
			}
	
			
			// 여기까지 보드 입력
			
			int max = -1;
			int[] dr = {1, -1, 0, 0};
			int[] dc = {0, 0, 1, -1};
			int[] dr2 = {1, 1, -1, -1};
			int[] dc2 = {1, -1, 1, -1}; 
			
			
			// 각 칸마다 분사!
			for(int r = 0; r < N; r++) {
				
				for(int c = 0; c < N; c ++) {
					int[][] newBo = new int[N][N];
					int[][] newBo2 = new int[N][N];
					int[][] visited =new int[N][N];
					
					for (int i = 0; i < visited.length; i++) {
						for (int j = 0; j < visited.length; j++) {
							visited[i][j] = 0;
						}
					}
					
					newBo = Arrays.copyOfRange(bo, 0, bo.length);
					newBo2 = Arrays.copyOfRange(bo, 0, bo.length);
					
					int temp = 0; 
					
					for(int cnt = 0; cnt < M; cnt++) {
						for(int d = 0; d<dr.length; d++) {
							int nr = r+dr[d]*cnt;
							int nc = c+dc[d]*cnt;
							if(nr>=0 && nc>=0 && nr<=N-1 && nc<=N-1) {
								if(visited[nr][nc]!=1) {
									
									temp +=newBo[nr][nc];
									visited[nr][nc] = 1;
								}
							}
						}
						
						
					}
//					System.out.println("r: " + r + ", c : "+ c + ", temp: "+ temp);
//					
					if(max<temp) {
						max = temp;
					}
					int temp2 = 0;
					
					int[][] visited2 = new int[N][N];
					for (int i = 0; i < visited.length; i++) {
						for (int j = 0; j < visited2.length; j++) {
							visited2[i][j] = 0;
						}
					}
					
					for(int cnt = 0; cnt < M; cnt++) {
						for(int d = 0; d<dr.length; d++) {
							int nr = r+dr2[d]*cnt;
							int nc = c+dc2[d]*cnt;
							if(nr>=0 && nc>=0 && nr<=N-1 && nc<=N-1) {
								if(visited2[nr][nc]!=1) {
									
									temp2 +=newBo2[nr][nc];
									visited2[nr][nc] = 1;
								}
							}
						}
						
						
					}
					
					if(max<temp2) {
						max = temp2;
					}
					
					
				}
			}
			
			System.out.println("#"+ (test+1)+" " + max);
		}
		
		
	}
}
