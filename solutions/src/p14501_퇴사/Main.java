package p14501_퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] Ts = new int[N];
		int[] Ps = new int[N];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Ts[i] = Integer.parseInt(st.nextToken());
			Ps[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			
			if(i + Ts[i] <= N) { // 상담 시간이 끝나도 은퇴 전날일 때
				d[i + Ts[i]] = Math.max(d[i+Ts[i]], d[i]+Ps[i]); // 상담이 끝난 날 번 돈은  상담 시작일까지 번 돈 + 지금부터 상담했을 때 받는 돈
			}
			
			d[i+1] = Math.max(d[i+1], d[i]);
			
		}
		
		System.out.println(d[N]);
		
		
		
	}

}
