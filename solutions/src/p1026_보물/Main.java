package p1026_보물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] As = new int[N];
		int[] Bs = new int[N];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Bs.length; i++) {
			As[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Bs.length; i++) {
			Bs[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(Bs);
		Arrays.sort(As);
		
		int sum = 0;
		for (int i = 0; i < Bs.length; i++) {
			sum += As[i]*Bs[Bs.length-1-i];
		}
		
		System.out.println(sum);
		
		
	}
}
