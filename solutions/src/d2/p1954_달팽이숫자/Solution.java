package d2.p1954_달팽이숫자;

import java.util.Scanner;

public class Solution {
	
	static int[][] snail;
	
	static int[] vecX = {+1, 0, -1, 0};
	static int[] vecY = {0, +1, 0, -1};
	
	static int num;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int testCase = 0; testCase < T; testCase++) {
			int N = sc.nextInt();
			
			num = 1;
			
			int stan = N*N;
			
			snail = new int[N][N];
			int pointer = 0;
			
			input(0, 0, pointer, N);
			
			System.out.println("#"+(testCase+1));
			for(int x = 0; x < N; x++) {
				for (int i = 0; i < N; i++) {
					System.out.print(snail[x][i] + " ");
				}
				System.out.println("");
			}
			
			
			
		}
	}
	
	static void input(int x, int y, int pointer, int N) {
		if(num>N*N) {
			return;
		}
		
//		System.out.println("x: "+ x + ", y: " + y + ", pointer: "+ pointer + ", N: " + N);
		
		if(x>=0 && x<=N-1 && y>=0 && y<=N-1 && snail[y][x]==0) {
			
			snail[y][x] = num++;
			
			
//		} else if(snail[y+vecY[pointer]][x+vecX[pointer]]=0) {
			
		} else {
			y-= vecY[pointer];
			x-=vecX[pointer];
			if(pointer+1==4) {
				pointer = 0;
			}else {
				pointer++;
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(snail[i][j] + " ");
//			}
//			System.out.println("");
//		}
		
		input(x+vecX[pointer], y+vecY[pointer], pointer, N);
		
		
		
	}
}
