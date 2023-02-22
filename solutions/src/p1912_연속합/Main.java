package p1912_연속합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		int[] maxes = new int[n];
		maxes[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxes[i] = Math.max(maxes[i-1]+arr[i], arr[i]);
		}
		Arrays.sort(maxes);
		bw.append(String.valueOf(maxes[n-1]));
		bw.flush();
		bw.close();
		br.close();
		
	}
}
