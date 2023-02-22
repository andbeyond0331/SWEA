package prac.day20230213;

public class Gravity {
	public static void main(String[] args) {
		int[] arr = {3, 2, 0, 4, 5, 0, 8, 7, 1, 0, 2};
		
		int[][] board = new int[100][100];
		
		// 가로 100 세로 100
		for(int c = 0; c < arr.length; c++) {
			for(int r = 0; r < 100; r++) {
				if(r<arr[c]) {
					board[r][c]=1;
				}else {
					break;
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
		int max = 0;
		for(int r = 0; r < board.length; r++) {
			for (int c = 0; c < board.length; c++) {
				if(board[r][c]==1) {
					int cnt = 0;
					
					for(int tmp = c; tmp < 100; tmp++) {
						if(board[r][tmp]==1) {
							cnt++;
						}
					}
					
					if(max<board.length-1-c-cnt) {
						max = board.length-1-c-cnt;
					}
				}
			}
		}
		
		System.out.println(max);
		
		
	}
}
