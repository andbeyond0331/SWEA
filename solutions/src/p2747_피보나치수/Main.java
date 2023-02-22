package p2747_피보나치수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] fibo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		int n = Integer.parseInt(st.nextToken());
		fibo = new int[n+1];
		fibo[0] = 0;
		fibo[1] = 1;
		
		fibon(n);
//		System.out.println(Arrays.toString(fibo));
		sb.append(fibo[n]);
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
	static int fibon(int num) {
		if(num == 1) {
			return 1;
		}
		if(num == 0) {
			return 0;
		}
		if(fibo[num]!=0) return fibo[num];
		
		return fibo[num] = fibon(num-2)+fibon(num-1);
	}
}
