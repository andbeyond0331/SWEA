//package p2304_창고다각형_unsolved;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.SortedSet;
//import java.util.StringTokenizer;
//import java.util.TreeSet;
//
//public class Main {
//	static int cnt;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder(); 
//		
//		int N = Integer.parseInt(br.readLine());
////		int[][] lh = new int[N][2]; // [N][0]: 각 기둥의 왼쪽 면 위치 && [N][1]: 기둥 높이
//
//		Map<Integer, Integer> map = new HashMap<>();
//		
//		cnt = 0;
//		
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//
//		}
//		
//		List<Integer> keySet = new ArrayList<>(map.keySet());
//		
//		Collections.sort(keySet);
//		
//		List<Integer> hs = new ArrayList<>();
//		for(int key: keySet) {
//			hs.add(map.get(key));
//		}
//		for (int i = 0; i < keySet.size(); i++) {
//			System.out.println(keySet.get(i) + " " + hs.get(i));
//			
//		}
//		
//		// 현재 왼쪽부터 차례로 담겨있음
//		// 벨류 셋 소팅해서 중복 없이 저장하기
//		SortedSet<Integer> orderedHeight = new TreeSet<>(hs);
//		System.out.println(Arrays.toString(orderedHeight.toArray()));
//		
//	}
//	
//	static void findTop(int s, int e, List<Integer> keySet, SortedSet<Integer> orderedHeight, Map<Integer, Integer> map) {
//		if(orderedHeight.size()==0) {
//			return;
//		}
//		
//		int last = orderedHeight.last();
//		List<Integer> tmpTops = new ArrayList<>();
//		
//		for (int key : map.keySet()) {
//			int value = map.get(key);
//			
//			if(value == last) {
//				tmpTops.add(key);
//			}
//		}
//		
//		if(tmpTops.size()==1) {
//			
//			cnt += last*tmpTops.get(0);
//			orderedHeight.remove(last);
//			if(tmpTops.get(0)==s) {
//				findTop(s+1, e, keySet, orderedHeight, map);
//			}else if(tmpTops.get(0)==e) {
//				findTop(s, e-1, keySet, orderedHeight, map);
//			}else {
//				findTop(s, last-1, keySet, orderedHeight, map);
//				findTop(last+1, e, keySet, orderedHeight, map);
//			}
//			
//		}else {
//			cnt+= last*(tmpTops.get(tmpTops.size()-1)-tmpTops.get(0));
//			orderedHeight.remove(last);
//			if(tmpTops.get(0)==s) {
//				findTop(tmpTops.get(tmpTops.size()-1)+1, e, keySet, )
//			}
//		}
//		
//		
//	}
//}
