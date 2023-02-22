package prac;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    char[] charactor = new char[str.length()];

    charactor = str.toCharArray();
    int word = 0;
    for (int i = 0; i < charactor.length; i++) {
        if (i + 1 < charactor.length) {
            word++;
            break;
        }
        if ((charactor[i] == 'c' && charactor[i + 1] == '=') || (charactor[i] == 'c' && charactor[i + 1] == '-')
                || (charactor[i] == 'd' && charactor[i + 1] == '-')
                || (charactor[i] == 'l' && charactor[i + 1] == 'j')
                || (charactor[i] == 'n' && charactor[i + 1] == 'j')
                || (charactor[i] == 's' && charactor[i + 1] == '=')
                || (charactor[i] == 'z' && charactor[i + 1] == '=')) {
            word++;
            i++;
        } else if (i+2<charactor.length && (charactor[i] == 'd' && charactor[i + 1] == 'z' && charactor[i + 2] == '=')) {
            word++;
            i++;
            i++;
        }
        else {
            word++;
        }
    }
    
    System.out.println(word);
}
}