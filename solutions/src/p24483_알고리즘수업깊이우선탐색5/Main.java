package p24483_알고리즘수업깊이우선탐색5;

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
	static long[] visited;
	static int R;
	static long[] d;
	static long cnt;
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
		visited = new long[N+1];
		d = new long[N+1];
		
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
		cnt = 1;
		int depth = 0;
		
		dfs(R, depth);
		
		long result = 0;
		
		for(int i = 1; i < visited.length; i++) {
			result += visited[i]*d[i];
		}
		
		sb.append(result);
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int num, int depth) {
		d[num] = cnt;
			
			visited[num] = depth;
			if(map.containsKey(num)) {
				for (int n: map.get(num)) {
					if(visited[n] == -2) {
						cnt++;
						dfs(n, depth+1);
					}
				}
				
				
			}
		
		
	}
}
