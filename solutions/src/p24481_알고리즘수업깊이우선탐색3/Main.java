package p24481_알고리즘수업깊이우선탐색3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static Map<Integer, Set<Integer>> map;
	static int[] visited;
	static int R;
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		Set<Integer> set;
		
		map = new HashMap<>();
		visited = new int[N+1];
		
		for (int i = 0; i < visited.length; i++) {
			visited[i] = -2;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(a)) {
				map.get(a).add(b);
			}else {
				set = new TreeSet<>();
				set.add(b);
				map.put(a,  set);
			}
			
			if(map.containsKey(b)) {
				map.get(b).add(a);
			}else {
				set = new TreeSet<>();
				set.add(a);
				map.put(b, set);
			}
		}
		int depth = 0;
		
		dfs(R, depth);
		
		for (int i = 1; i < visited.length; i++) {
			if(visited[i]==-2) {
				sb.append("-1");
			}else {
				sb.append(visited[i]);
			}
			sb.append("\n");
		}
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int num, int depth) {
//		if(depth>visited[num]) {
			
			visited[num] = depth;
			if(map.containsKey(num)) {
				for (int n: map.get(num)) {
					if(visited[n] == -2) {
						dfs(n, depth+1);
					}
				}
				
				
			}
//		}
		
		
	}
}
