package p1208_Flatten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			
			int dump = Integer.parseInt(br.readLine());
			
			int[] box = new int[101];
			int[] blank = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < 101; j++) {
				int height = Integer.parseInt(st.nextToken());
				for(int k = 1; k <= height; k++) {
//					System.out.println("height: " + height);
					box[k]++;
				}
			}
			for(int j = 1; j < 101; j++) {
				blank[j] = 100-box[j];
			}
			int min = 101; // 최저층
			int max = 0; // 최고층
			for (int j = 1; j < 101; j++) {
				if(blank[j]>0) {
					min = j;
					break;
				}
			}
			for (int j = 100; j > 0; j--) {
				if(box[j]>0) {
					max = j;
					break;
				}
			}
			if(i==6) {
				System.out.println("min: " + min + ", max: " + max);
				System.out.println(Arrays.toString(box));
				System.out.println(Arrays.toString(blank));
			}
			boolean flag = false;
			while(dump>0) {
				int tmpMin = blank[min];
				int tmpMax = box[max];
				if(tmpMax<tmpMin) { // 최하층보다 최고층이 더 작으면
					blank[min]-=box[max]; // 최고층 박스를 최하층 빈칸에 채우기
					blank[max] = 100; // 최고층 박스만큼 최고층 빈칸 채우기
					dump-=box[max]; // 최고층 박스만큼 덤프횟수 차감
					box[min] += box[max]; // 최하층 박스를 최고층 박스만큼 채우기
					box[max] = 0;
					max--;
					flag = true;
				}else if(tmpMax==tmpMin) { /// 최하층과 최고층 같으면
					dump-=box[max]; // 최고층 박스만큼 덤프횟수 차감
					
					box[max] = 0;
					box[min] = 100;
					blank[max] = 100;
					blank[min] = 0;
					max--;
					min++;
					flag = false;
				}else { // 최하층보다 최고층이 더 크면
					box[max]-=blank[min]; // 최하층 빈칸을 최고층 박스로 채우기
					
					dump-=blank[min];
//					blank[min] =100;
//					box[max] = 0;
					min++;
					flag = true;
				}
			}
			if( flag) {
				
				System.out.printf("#%d %d\n", i+1, (max+1)-(min-1));
			}else {
				
				System.out.printf("#%d %d\n", i+1, (max)-(min-1));
			}
			
			
			
			
		}
		
		
	}
}
