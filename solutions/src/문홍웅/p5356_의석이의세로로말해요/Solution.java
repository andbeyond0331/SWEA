package 문홍웅.p5356_의석이의세로로말해요;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        // 1. 입력을 받자
        Scanner sc = new Scanner(System.in);

    // 2. 테스트 케이스를 입력 받자
    int testCase = sc.nextInt();

    for (int tc = 1; tc <= testCase; tc++) {

        // 3. 스택 선언
        Stack<Character> stack = new Stack<>();

        // 4. 문자열 입력받아 문자 배열로 바꾸기
        String str;
        char[][] character = new char[5][15];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                character[i][j] = '`';
            }
        }

        for (int i = 0; i < 5; i++) {
            str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                character[i][j] = str.charAt(j);
            }
        }

        for (int j = 14; j >= 0; j--) {
            for (int i = 4; i >= 0; i--) {
                if (character[i][j] != '`') {
                    stack.push(character[i][j]);
                }
            }
        }
        System.out.print("#" + tc + " ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();

    }
}
}