package d4.p4613_러시아국기같은깃발;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				StringTokenizer st;
				StringBuilder sb = new StringBuilder();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
				int T = Integer.parseInt(br.readLine());
				char[][] flag;
				int[][] count;
				
				for (int i = 1; i <= T; i++) {
					st = new StringTokenizer(br.readLine());
					int N = Integer.parseInt(st.nextToken());
					int M = Integer.parseInt(st.nextToken());
					
					int[] toW = new int[N];
					int[] toB = new int[N];
					int[] toR = new int[N];
					
					flag = new char[N][M];
					count = new int[N][3];
					int min = Integer.MAX_VALUE;
					for (int j = 0; j < N; j++) {
						String line = br.readLine();
						for (int k = 0; k < M; k++) {
							flag[j][k] = line.charAt(k);
							if(flag[j][k]=='W') {
								count[j][0]++;
							}else if(flag[j][k]=='R') {
								count[j][1]++;
							}else if(flag[j][k]=='B') {
								count[j][2]++;
							}else {
								System.out.println("이상이상!!!");
							}
						}
						toW[j] = count[j][1]+count[j][2];
						toB[j] = count[j][0]+count[j][1];
						toR[j] = count[j][2]+count[j][0];
					}
					for (int j = 1; j <= N-2; j++) {
						// j는 블루의 스타트
						for (int end = j; end <= N-2; end++) {
							int cnt = 0;
							for (int b = 1; b < j; b++) {
								cnt+=toW[b];
							}
							for(int b = j; b <= end; b++) {
								cnt+=toB[b];
							}
							for(int b = end+1; b<=N-2; b++) {
								cnt+=toR[b];
							}
							min = Math.min(cnt, min);
						}
					}
					
					min+= toW[0] + toR[N-1];
					sb.append("#");
					sb.append(i);
					sb.append(" ");
					sb.append(min);
					sb.append("\n");
					
				}
				
				bw.append(sb);
				bw.flush();
				bw.close();
				br.close();
			}
}
