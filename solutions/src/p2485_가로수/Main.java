package p2485_가로수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] tree = new int[N];
		int min = 0;
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(br.readLine());
			if(i>1) {
				min = Math.min(tree[i]-tree[i-1], min);
			}
		}
		
		// FLAG를 둬서 최소 길이보다 작은 간격이 있으면 최소 길이를 걔로 두고 FLAG FALSE
		// 최소 길이보다 작은 간격이 없으면 FLAG TRUE
		
	}
}
