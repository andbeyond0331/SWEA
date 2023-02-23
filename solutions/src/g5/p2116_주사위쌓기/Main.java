package g5.p2116_주사위쌓기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 주사위 개수
		List<List<Integer>>[] dices = new ArrayList[N];
		
		long result = 0;
		
		for (int i = 0; i < N; i++) {
			List<Integer> tmp1 = new ArrayList<>();
			List<Integer> tmp2 = new ArrayList<>();
			List<Integer> tmp3 = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			tmp1.add(Integer.parseInt(st.nextToken()));
			tmp2.add(Integer.parseInt(st.nextToken()));
			tmp3.add(Integer.parseInt(st.nextToken()));
			tmp2.add(Integer.parseInt(st.nextToken()));
			tmp3.add(Integer.parseInt(st.nextToken()));
			tmp1.add(Integer.parseInt(st.nextToken()));
			
			List<List<Integer>> l = new ArrayList<>();
			l.add(tmp1);
			l.add(tmp2);
			l.add(tmp3);
			dices[i] = l;
		}
		
		for (int firstEye = 1; firstEye <= 6; firstEye++) { // 첫번째 주사위의 눈 수
			int tmp = firstEye;
			long cnt = 0;
			if(dices[0].get(0).contains(tmp)){// 만약 0번째 list에 눈 있으면
				cnt += Math.max(Math.max(dices[0].get(1).get(0), dices[0].get(0).get(1)), 
						Math.max(dices[0].get(2).get(0), dices[0].get(2).get(1)));
			} else if(dices[0].get(1).contains(tmp)) {
				cnt += Math.max(Math.max(dices[0].get(0).get(0), dices[0].get(0).get(1)), 
						Math.max(dices[0].get(2).get(0), dices[0].get(2).get(1)));
			}else {
				cnt += Math.max(Math.max(dices[0].get(1).get(0), dices[0].get(1).get(1)), 
						Math.max(dices[0].get(0).get(0), dices[0].get(0).get(1)));
			}
			
			
			for (int diceNum = 1; diceNum < N; diceNum++) { // 주사위 수만큼 돌리는데
				// 이전 주사위 위쪽 눈금 수 찾기
				// dices[diceNum-1].get(0).contains(tmp);
				
				// 아래 if 안에서 해야 할 로직
				//	옆면 중 가장 숫자 낮은 애 cnt 추가
				//	다음에 올 위를 tmp에 저장
//				System.out.println("tmp: " + tmp + ", diceNum: " + diceNum);
				if(dices[diceNum].get(0).contains(tmp)) { // 만약 0번째 list에 눈 있으면
					cnt += Math.max(Math.max(dices[diceNum].get(1).get(0), dices[diceNum].get(1).get(1)), Math.max(dices[diceNum].get(2).get(0), dices[diceNum].get(2).get(1)));
					tmp = dices[diceNum].get(0).get(1-dices[diceNum].get(0).indexOf(tmp));
				}else if(dices[diceNum].get(1).contains(tmp)) {
					cnt += Math.max(Math.max(dices[diceNum].get(0).get(0), dices[diceNum].get(0).get(1)), Math.max(dices[diceNum].get(2).get(0), dices[diceNum].get(2).get(1)));
					tmp = dices[diceNum].get(1).get(1-dices[diceNum].get(1).indexOf(tmp));
				}else {
					cnt += Math.max(Math.max(dices[diceNum].get(0).get(0), dices[diceNum].get(0).get(1)), Math.max(dices[diceNum].get(1).get(0), dices[diceNum].get(1).get(1)));						
					tmp = dices[diceNum].get(2).get(1-dices[diceNum].get(2).indexOf(tmp));
				}
					
				
				
			}
			result = Math.max(cnt, result);
		}
		sb.append(result);
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}
