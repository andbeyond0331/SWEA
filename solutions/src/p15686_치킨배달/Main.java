package p15686_치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		int[] ddr = {1, 1, -1, -1};
		int[] ddc = {1, -1, 1, -1};
		
		List<String> houses = new ArrayList<String>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					houses.add(i+" "+j); // 치킨집 저장
				}
			}
			
		}
		int[] cd = new int[houses.size()];
		
		for(String home: houses) {
			st = new StringTokenizer(home, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			boolean flag = false;
			for(int i = 0; i < dr.length; i++) {
				if(flag) {
					break;
				}
				
			}
			
		}
		
		
		
		
	}
}
