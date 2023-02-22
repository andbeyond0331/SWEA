package p24060_알고리즘수업병합정렬1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int count = 0;
	public static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer first = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(first.nextToken());
		int K = Integer.parseInt(first.nextToken());
		
		int[] arr = new int[N];
		StringTokenizer second = new StringTokenizer(br.readLine(), " ");
		for(int a = 0; a < N; a++) {
			arr[a] = Integer.parseInt(second.nextToken());
		}
		
		if(count<=K) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		
		
		
		
	}
	
	public static void merge_sort(int[] arr, int p, int r) {
		if(p < r) {
			int q = (int) Math.floor((p+r)/2);
			merge_sort(arr, p, q);
			merge_sort(arr, q+r, r);
			merge(arr, p, q, r);
		}
	}
	
	public static void merge(int[] arr, int p, int q, int r) {
		int i = p;
		int j = q+1;
		int t = 1;
		
		int[] tmp = new int[arr.length];
		
		
		while(i <= q && j <= r) {
			if(arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
				tmp[t] = arr[i];
				t++;
				i++;
			}else {
				tmp[t++] = arr[j++];
				tmp[t] = arr[j];
				t++;
				j++;
			}
		}
		
		while(i <= q) {
			tmp[t++] = arr[i++];
		}
		while(j <= r) {
			tmp[t++] = arr[j++];
		}
		i = p;
		t = 1;
		while (i <= r) {
			arr[i++] = tmp[t++];
		}
		
	}
}
