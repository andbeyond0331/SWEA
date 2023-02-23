package 문홍웅.p1225_암호생성기_원형큐;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	// 큐로 사용할 배열, front , rear 생성
	public static int[] queue = new int[9];
	public static int front = 0, rear = 0;

	public static void main(String[] args) {
	    // 1. 입력을 받자
	    Scanner sc = new Scanner(System.in);

	    // 2. 테스트 케이스 10개 고정
	    for (int tc = 1; tc <= 1; tc++) {
	        // 테스트 케이스 번호르 입력 받음
	        int testCaseNum = sc.nextInt();

	        for(int i = 0 ; i < 8; i++) {
	            int num = sc.nextInt();
//	            System.out.println(num);
	            enqueue(num);
//	            queue[i+1] = num;
	            System.out.println(Arrays.toString(queue) + ": "+i);
	        }
	        System.out.println(Arrays.toString(queue));
	        // 5. 숫자가 하나 0이 될 떄까지 반복
	        int count = 1;
	        while (true) {
	            // 두번 째 싸이클
	            if (count == 6) {
	                count = 1;
	            }

	            // 첫 번쨰 인덱스를 빼내고 , 저장
	            int tmp = dequeue();
	            
	            // 마지막에 다시 저장
	            enqueue(tmp - count);
	            // 배열을 재배열
	        
	            // 0이하가 되면 반복문 정지
	            if (queue[rear] <= 0) {
	                queue[rear] = 0;
	                break;
	            }

	            // 감소 값 상승
	            count++;

	        }
	        System.out.println(Arrays.toString(queue));

	        System.out.print("#" + testCaseNum);
	        for (int i = 0; i < 8; i++) {
	            System.out.print(" " + dequeue());
	        }
	        System.out.println();
	    }
	}

	public static boolean isFull() {
	    if((rear+1) % 9 == front) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}

	// 8개의 입력을 큐에 넣을 때 사용
	public static void enqueue(int item) {
	    if(!isFull()) {
	        rear = (rear + 1) % 9; 
	        queue[rear] = item;
	    }else {
	    	System.out.println("큐 가득 찼는디 어케 넣음?");
	    }
	}

	// 큐의 맨 앞의 놈을 꺼냄
	public static int dequeue() {
	    front = (front + 1) % 9;
	    return queue[front];
	}

	// 큐가 비었는지 확인
	public static boolean isEmpty() {
	    if (front == rear) {
	        return true;
	    } else {
	        return false;
	    }
	}
	}
