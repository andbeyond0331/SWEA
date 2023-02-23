package p1074_Z;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long cnt;
	static int r;
	static int c;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int Max = (int)Math.pow(2, N);
		
		cnt = 0;
		
		find(N, 0, Max-1, 0, Max-1);
		
		sb.append(cnt);
		
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void find(int n, int r1, int r2, int c1, int c2) {
		if(n==0) {
			return;
		}
		if(r1<=r && r<=(r2-r1)/2) { // 위층?
			if(c1<=c && c<=(c2-c1)/2) { // 왼쪽?
				System.out.println("111111111111");
				find(n-1, r1, (r2-r1)/2, c1, (c2-c1)/2); 
			}else {// 오른쪽?
				System.out.println("2222222222222");
				cnt+=((long)Math.pow(2, n))*((long)Math.pow(2, n))/4;
				find(n-1, r1, (r2-r1)/2, (c2-c1)/2+1, c2); 
				
			}
		}else { //아래층?
			if(c1<=c && c<=(c2-c1)/2) { // 왼쪽?
				System.out.println("333333333333");
				cnt+=((long)Math.pow(2, n))*((long)Math.pow(2, n))/4*2;
				find(n-1, (r2-r1)/2+1, r2, c1, (c2-c1)/2); 
			}else {// 오른쪽?
				System.out.println("4444444444");
				cnt+=((long)Math.pow(2, n))*((long)Math.pow(2, n))/4*3;
				find(n-1, (r2-r1)/2+1, r2, (c2-c1)/2+1, c2); 
				
			}
		}
	}
}
