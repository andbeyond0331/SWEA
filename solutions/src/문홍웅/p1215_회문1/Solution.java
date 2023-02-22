package 문홍웅.p1215_회문1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 1.입력을 받자
        Scanner sc = new Scanner(System.in);
        char[][] map = new char[8][8]; // 맵 사이즈 8로 고정

    // 2. testCase는 10개로 고정
    for (int tc = 1; tc <= 10; tc++) {
        // 3. 회문 길이를 입력 받자
        int length = sc.nextInt();

        // 4. 맵을 입력받자
        for (int i = 0; i < 8; i++) {
            String str = sc.next(); // 한 줄을 입력 받아서
            for (int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j); // 배열에 넣자 !
            }
        }

        int count = 0; // 회문의 개수를 저장하는 변수
        for (int row = 0; row < 8; row++) { // length보다 적게 남은 배열은 볼 필요가 없다.
            for (int col = 0; col <= (8 - length); col++) { // 가로 탐색 !!
                for (int i = 0; i < (length / 2); i++) {
                    if (map[row][col+i] != map[row][col + length - 1 - i]) { // 5글자가 회문인지 확인하자 !
                        break; // 회문이 아니면 멈추기
                    }else if (i == (length / 2) - 1) { // 회문이라면
                        count++; // 개수 증가 !
                    }
                }
            }
        }

        for (int col = 0; col < 8; col++) { // length보다 적게 남은 배열은 볼 필요가 없다.
            for (int row = 0; row <= (8 - length); row++) { // 세로 탐색 !!
                for (int i = 0; i < (length / 2); i++) {
                    if (map[row+i][col] != map[row + length - 1 - i ][col]) {// 5글자가 회문인지 확인하자 !
                        break;// 회문이 아니면 멈추기
                    }else if (i == (length / 2) - 1 ) {// 회문이라면
                        count++;// 개수 증가 !
                    }
                }
            }
        }
        System.out.println("#" + tc + " " + count);
    }
}
}

