package p24480_알고리즘수업깊이우선탐색2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static Map<Integer, Set<Integer>> map;
	static int[] visited;
	static int cnt;
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		Set<Integer> set;
		
		cnt = 1;
		
		map = new HashMap<>();
		visited = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(u)) {
				map.get(u).add(v);
			}else {
				set = new TreeSet<>();
				set.add(v);
				map.put(u,  set);
			}
			
			if(map.containsKey(v)) {
				map.get(v).add(u);
			}else {
				set = new TreeSet<>();
				set.add(u);
				map.put(v,  set);
			}
		}
		
		dfs(R);
		
		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i]);
			sb.append("\n");
			
		}
		
		
		
		
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
		
		
		
	}

	static void dfs(int num) {
		visited[num] = cnt;
		if(map.containsKey(num)) {
			Object[] arr = map.get(num).toArray();
			for (int i = arr.length-1; i >=0; i--) {
				if(visited[(int) arr[i]]==0) {
					cnt++;
					dfs((int)arr[i]);
				}
			}
		}
		
	}
}
