package p1974_스도쿠검증;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		List<Integer> list = new ArrayList<>();
		
		int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
	
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 0; testCase < T; testCase++) {
			int[][] board = new int[9][9];
			for(int r = 0; r < 9; r ++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int c = 0; c < 9; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 여기까지 판에 담음
//			for(int r = 0; r < 9; r ++) {
//				
//				for(int c = 0; c < 9; c++) {
//					System.out.print(board[r][c]);
//				}
//				System.out.println();
//			}
//			
			boolean flag = true; // 이상 없다면 true
			
			// 가로 검열
			for(int r = 0; r < 9; r++) {
//				ArrayList<Integer> newL = new ArrayList<>(Arrays.asList(list));
				List newL = new ArrayList<>();
				for(int i = 0; i < 9 ; i ++) {
					newL.add(list[i]);
				}
				for(int c = 0; c < 9; c++) {
					
					if(newL.contains(board[r][c])) {
						
						newL.remove(newL.indexOf(board[r][c]));
					}else {
						flag = false;
						break;
					}
				}
			}
			
			if(flag) {
				for(int r = 0; r < 9; r++) {
					List newL = new ArrayList<>();
					for(int i = 0; i < 9 ; i ++) {
						newL.add(list[i]);
					}
					for(int c = 0; c < 9; c++) {
						if(newL.contains(board[c][r])) {
							newL.remove(newL.indexOf(board[c][r]));
						}else {
							flag = false;
							break;
						}
					}
				}
			}
			
			if(flag) {
				for(int r = 0; r < 3; r++) {
					
					
					
					for(int c = 0; c<3; c++) {
						List newL = new ArrayList<>();
						for(int i = 0; i < 9 ; i ++) {
							newL.add(list[i]);
						}
						
//						for(int a = 0; a < 9; a ++) {
//							
//							System.out.println(newL.get(a));
//						}
						if(newL.contains(board[3*r][3*c])) {
							newL.remove(newL.indexOf(board[3*r][3*c]));
						}else {
							flag = false;
//							System.out.println("r: " + r + ", c : "+ c);
//							System.out.println(Arrays.toString(newL.toArray()));
							break;
						}
						
						if(newL.contains(board[3*r][3*c+1])) {
							newL.remove(newL.indexOf(board[3*r][3*c+1]));
						}else {
							flag = false;
//							System.out.println("r: " + r + ", c : "+ c);
//							System.out.println(Arrays.toString(newL.toArray()));
							break;
						}

						if(newL.contains(board[3*r][3*c+2])) {
							newL.remove(newL.indexOf(board[r*3][c*3+2]));
						}else {
							flag = false;
//							System.out.println("r: " + r + ", c : "+ c);
//							System.out.println(Arrays.toString(newL.toArray()));
							break;
						}
						

						if(newL.contains(board[3*r+1][3*c])) {
							newL.remove(newL.indexOf(board[r*3+1][3*c]));
						}else {
							flag = false;
//							System.out.println("r: " + r + ", c : "+ c);
//							System.out.println(Arrays.toString(newL.toArray()));
							break;
						}
						

						if(newL.contains(board[3*r+1][3*c+1])) {
							newL.remove(newL.indexOf(board[r*3+1][c*3+1]));
						}else {
							flag = false;
//							System.out.println("r: " + r + ", c : "+ c);
//							System.out.println(Arrays.toString(newL.toArray()));
							break;
						}
						
						if(newL.contains(board[3*r+1][3*c+2])) {
							newL.remove(newL.indexOf(board[r*3+1][3*c+2]));
						}else {
							flag = false;
//							System.out.println("r: " + r + ", c : "+ c);
//							System.out.println(Arrays.toString(newL.toArray()));
							break;
						}
						
						
						if(newL.contains(board[3*r+2][3*c])) {
							newL.remove(newL.indexOf(board[3*r+2][c*3]));
						}else {
							flag = false;
//							System.out.println("r: " + r + ", c : "+ c);
//							System.out.println(Arrays.toString(newL.toArray()));
							break;
						}
						
						if(newL.contains(board[3*r+2][3*c+1])) {
							newL.remove(newL.indexOf(board[r*3+2][c*3+1]));
						}else {
							flag = false;
//							System.out.println("r: " + r + ", c : "+ c);
//							System.out.println(Arrays.toString(newL.toArray()));
							break;
						}
						
						if(newL.contains(board[3*r+2][3*c+2])) {
							newL.remove(newL.indexOf(board[r*3+2][c*3+2]));
						}else {
							flag = false;
//							System.out.println("r: " + r + ", c : "+ c);
//							System.out.println(Arrays.toString(newL.toArray()));
							break;
						}
						
						
					}
				}
			}
			
			if(flag) {
				System.out.println("#" + (testCase+1) + " " + 1);
			}else {
				System.out.println("#" + (testCase+1) + " 0");
			}
			
		}
		
		
		
	}

}
