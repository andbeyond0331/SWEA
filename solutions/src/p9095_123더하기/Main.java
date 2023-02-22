package p9095_123더하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] number;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			
			number = new int[n+1];
			if(n==1) {
				number[1] = 1;
			}else if(n==2) {
				number[1] = 1;
				number[2] = 2;
				
			}else {
				number[1] = 1;
				number[2] = 2;
				number[3] = 4;
			}
			
			
			sb.append(func(n));
			sb.append("\n");
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
	static int func(int num) {
		
		if(number[num]!=0) {
			return number[num];
		}
		return number[num] = func(num-3) + func(num-2) + func(num-1);
	}
}
