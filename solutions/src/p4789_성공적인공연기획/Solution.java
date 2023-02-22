package p4789_성공적인공연기획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			
			String clap = br.readLine();
			
			int[] applause = new int[clap.length()];
			
			
			
			for(int c = 0; c < applause.length; c++) {
				applause[c] = Integer.parseInt(clap.substring(c, c+1));
			}
			
//			for (int i = 0; i < applause.length; i++) {
//				System.out.println(applause[i]);
//			}
			
			int sum = 0; // 박수치고있음
			int plus = 0; // 고용해야함
			for(int c = 0; c < applause.length; c++) {
				if(c <= sum) {
//					System.out.println("c: " + c + " aaaaaaa, sum: " + sum);
					sum+=applause[c];
				}else {
//					System.out.println("c: " + c + " bbbbbbb, sum: " + sum);
					if(applause[c]!=0) {
						plus+=c-sum;
						sum+=c-sum;
						sum+=applause[c];
					}
					
				}
			}
			
			
			
			
			
			System.out.println("#" + test + " " + plus );
		}
	}
}
