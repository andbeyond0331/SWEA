package p1208_Flatten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			int dump = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] box = new int[100];
			for (int j = 0; j < 100; j++) {
				box[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(box);
			
			for (int j = 0; j <dump; j++) {
				box[0]++;
				box[99]--;
				Arrays.sort(box);
			}
			
			System.out.printf("#%d %d\n", i+1, box[99]-box[0]);
			System.out.println(Arrays.toString(box));
			
		}
		
		
	}
}
