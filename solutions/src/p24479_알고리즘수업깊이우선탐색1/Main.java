package p24479_알고리즘수업깊이우선탐색1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N;
	static int M;
	static Map<Integer, Set<Integer>> map;
//	static int[] V;
//	static int[] E;
	static int[] visited;
	static int cnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		Set<Integer> s;
		
		map = new HashMap<>();
		
//		V = new int[M];
//		E = new int[M];
		
		visited = new int[N+1];
		cnt = 1;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(map.containsKey(v)) {
				map.get(v).add(e);
			}else {
				s = new TreeSet<Integer>();
				s.add(e);
				map.put(v, s);
			}
			if(map.containsKey(e)) {
				map.get(e).add(v);
			}else {
				s = new TreeSet<Integer>();
				s.add(v);
				map.put(e, s);
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
	
	static void dfs(int x) {
		visited[x] = cnt;
//		System.out.println(Arrays.toString(visited));
//		List<Integer> near = new ArrayList<Integer>();
//		for (int i = 0; i < V.length; i++) {
//			if(V[i] == x) {
//				near.add(E[i]);
//			}
//			
//			if(E[i] == x) {
//				near.add(V[i]);
//			}
//		}
		if(map.containsKey(x)) {
			for(int num : map.get(x)) {
				if(visited[num]==0) {
					cnt++;
	//				map.get(x).remove(num);
	//				map.get(num).remove(x);
					dfs(num);
				}
			}
		}
		
//		near.sort(Comparator.naturalOrder());
////		System.out.println(Arrays.toString(near.toArray()));
//		for (int i = 0; i < near.size(); i++) {
//			if(visited[near.get(i)] == 0) {
//				cnt++;
//				dfs(near.get(i));
//			}
//		}
	}
}
