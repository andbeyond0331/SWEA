package p5432_쇠막대기자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			
			String pipe = br.readLine();
			
			pipe = pipe.replaceAll("()", "--");
			
			System.out.println("#" + test + " " + pipe );
		}
			
			
			
			
	
	}
}
