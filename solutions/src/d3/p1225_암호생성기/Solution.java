package d3.p1225_암호생성기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	static int n = 8;
	static int[] arr;
	static int front, rear;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[n];
			front = -1;
			rear = -1;
			for (int i = 0; i < 8; i++) {
				
				enQueue(Integer.parseInt(st.nextToken()));
			}
//			System.out.println(Arrays.toString(arr) + ": " + t);
			
			boolean flag = true;
			while(flag) {
				int minus = 1;
				for (int i = 0; i < 5; i++) {
					arr[0] = arr[0]-minus<=0?0:arr[0]-minus;
					minus++;
					int put = deQueue();
					enQueue(put);
					if(arr[arr.length-1] == 0) {
						flag = false;
						break;
					}
				}
				
			}
//			System.out.println(Arrays.toString(arr) + ": " + t);
			
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			for (int i = 0; i <= arr.length-1; i++) {
				sb.append(arr[i]);
				if(arr.length-1==i) {
					sb.append("\n");
					
				} else {
					
					sb.append(" ");
				}
			}
			
		}
		
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
	
	// enQueue(item) : 삽입
		public static void enQueue(int item) {
			if(isFull()) { // 포화상태라면
				System.out.println("큐에 더이상 값을 넣을 수 없습니다.");
			} else { // rear != n-1 => 포화상태가 아닌 경우
				arr[++rear] = item;
			}
		}
		
		
		// deQueue : 삭제
		public static int deQueue() {
			if(isEmpty()) { // 큐가 비어있다면
				System.out.println("큐가 비어있어서 deQueue 안됨.");
				return -1;
			} else {
				// front를 늘이는 것이 아니라
				// REAR를 앞으로 당긴다.
				// FRONT는 항상 -1로 고정
				int temp = arr[front+1]; // 임시 변수에 현재 가장 앞에 있는 원소 저장
				// 모든 원소를 한 칸 앞으로 당기면서 덮어쓰기 한다.
				for(int i = 0; i <= rear-1; i++) {
					arr[i] = arr[i+1];
				}
				rear--; // 삭제 완료
				
				// 삭제 원소 반환
				return temp;
			}
		}
		
		// peek : 가장 첫번째 원소 확인(삭제 x, 반환 o)
		public static int peek() {
			if(isEmpty()) {
				System.out.println("큐가 비어있어서 peek이 안됨.");
				return -2;
			} else {
				return arr[front + 1]; // 삭제하지 않고, 현재 첫번째 원소를 반환
				// front+1 : 현재 첫번째 원소의 idx
			}
		}
		
		
		// print : 현재 큐의 원소들 출력
		public static void print() {
			if(isEmpty()) {
				System.out.println("큐가 비어있어서 출력이 안돼요..");
			} else {
				// 어디서부터 어디까지???
				// 첫번째 원소부터 마지막 원소까지..
				for(int i=front+1; i<=rear; i++) {
					System.out.printf("[%d]: %d ", i, arr[i]);
				}
				System.out.println();
			}
		}
		
		// isEmpty : 큐가 비어있는지
		public static boolean isEmpty() {
			return front == rear;
		}
		
		
		// isFull : 큐가 꽉차있는지(포화상태인지, 원소를 추가할 수 있는지)
		public static boolean isFull() {
			return rear == n-1;
		}
		
		// size : 현재 큐의 원소의 개수 ??
		public static int size() {
			return rear - front;
		}
}
