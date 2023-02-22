package p10867_중복빼고정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new LinkedHashSet<Integer>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int[] arr = new int[set.size()];
		int idx = 0;
		for(int num: set) {
			arr[idx++] = num;
		}
		
		Arrays.sort(arr);
		
		for(int num: arr) {
			System.out.print(num + " ");
		}
	}
}
