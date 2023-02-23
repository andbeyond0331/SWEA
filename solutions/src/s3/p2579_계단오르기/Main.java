package s3.p2579_계단오르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] j = new int[N+1];
		int[] nj = new int[N+1];
		int[] scores = new int[N+1];
		for (int s = 0; s <N+1 ; s++) {
			scores[s] = Integer.parseInt(br.readLine());
		}
		j[1] = scores[1]; // 이전꺼 안 밟은 최댓값 저장
		nj[1] = scores[1]; // 이전꺼 밟은 최댓값 저장
		
		for (int i = 0; i < scores.length; i++) {
			if(i==1) {
				j[i] = scores[0];
				nj[i] = scores[0]+scores[1];
			} else if(i >= 2) {
				j[i] = Math.max(Math.max(j[i-1], nj[i-2]+scores[i]), j[i-2]+scores[i]);
				nj[i] = j[i-1]+scores[i];
			}
		}
		System.out.println(Arrays.toString(j));
		System.out.println(Arrays.toString(nj));
		sb.append(Math.max(j[N], nj[N]));
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}
