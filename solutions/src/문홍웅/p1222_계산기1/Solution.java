package 문홍웅.p1222_계산기1;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        // 1. 입력을 받자
        Scanner sc = new Scanner(System.in);

    // 2. 10개의 테스트 케이스
    for (int tc = 1; tc <= 10; tc++) {
        // 3. 계산식의 길이를 입력 받자
        int stringNum = sc.nextInt();

        // 4. 계산식을 입력받자
        String str = sc.next();

        // 5. 출력하자
        System.out.println(change(str));
        System.out.println("#" + tc + " " + calculate(change(str)));
    }

}

// 연산자 우선순위를 결정하자
public static int checkValue(char c) {

    // 1. 곱셈이나 나눗셈이 가장 순위가 높다
    if (c == '*' || c == '/') {
        return 3;
    }
    // 2. 그 다음은 덧셈 뺄셈
    else if (c == '+' || c == '-') {
        return 2;
    }
    // 3. 괄호는 제일 낮음
    else if (c == '(') {
        return 1;
    }

    return 0;
}

// 연산자 우선순위를 비교하자
public static int compareValue(char c1, char c2) {
    int stack = checkValue(c1); // 스택의 맨 위에 있는 놈
    int com = checkValue(c2); // 현재 비교할 놈

    // 1. 현재 비교할 놈이 순위가 더 높으면
    if (stack < com) {
        return 1;
    }
    // 2. 같으면
    else if (stack == com) {
        return 0;
    }
    // 3. 작으면
    else {
        return -1;
    }

}

// 후위 계산자로 변경하자
public static String change(String str) {
    StringBuilder sb = new StringBuilder();
    Stack<Character> op = new Stack<>();
    char character;
    for (int i = 0; i < str.length(); i++) {
        character = str.charAt(i);

        // 1. 만약 숫자라면 그냥 출력
        if (Character.isDigit(character)) {
            sb.append(character);
        }

        // 2. 만약 스택이 비었으면 그냥 push
        else if (op.isEmpty()) {
            op.push(character);
        }

        // 3. ( 이면

        else if (character == '(') {
            op.push(character);
        }

        // 4. ) 이면
        else if (character == ')') {
            while (true) { // ( 가 나올 때 까지 pop, append
                char c = op.pop();
                if (c == '(') {
                    break;
                }
                sb.append(c);
            }
        }

        // 5. 다른 연산자 이면
        else {
            // 6. 우선 순위가 더 높으면
            if (compareValue(op.peek(), character) == 1) {
                op.push(character);
            }

            // 7. 우선 순위가 같거나 작은 경우
            else if (compareValue(op.peek(), character) <= 0) {
                sb.append(op.pop()); // 하나를 pop하고 출력
                op.push(character);
            }
        }
    }

    return sb.toString();
}

public static int calculate(String str) {
    Stack<Integer> cal = new Stack<>();

    int num1;
    int num2;

    for (int i = 0; i < str.length(); i++) {
        char character = str.charAt(i);

        // 1. 숫자면 바로 int형으로 변환 후 push
        if (Character.isDigit(character)) {
            cal.push(character - '0');
            System.out.print((character-'0')+" ");
        }
        // 2. 연산자 이면 계산을 해야함
        else {
            if (character == '+') {
                num1 = cal.pop();
                num2 = cal.pop();
                System.out.println("num2: " + num2 + ", num1: " + num1);
                cal.push(num2 + num1);
            } else if (character == '-') {
                num1 = cal.pop();
                num2 = cal.pop();
                cal.push(num2 - num1);
            } else if (character == '*') {
                num1 = cal.pop();
                num2 = cal.pop();
                cal.push(num2 * num1);
            } else if (character == '/') {
                num1 = cal.pop();
                num2 = cal.pop();
                cal.push(num2 / num1);
            }else {
            	System.out.println("Wrong!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        }

    }

    return cal.pop();

}
}