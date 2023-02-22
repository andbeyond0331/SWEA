
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
       
        // 색종이 수
        int n = Integer.parseInt(br.readLine());
       
        int[][] white =new int[100][100];
       
        String a = "123";
        a.substring(0,1);
       
        for(int i = 0; i < n; i++) { // 색종이 수만큼 for문 돌리기

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
           
           
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
           
            for(int j = 0; j < 10; j ++) {
                for(int k = 0; k < 10; k++) {
                    white[x+j][y+k] = 1;
                }
            }
           
           
        }
        int sum =0;
        for(int i = 0; i < 100; i ++) {
            for(int j = 0; j < 100; j++) {
                if(white[i][j]==1) {
                    sum++;
                }
            }
        }
       
        System.out.println(sum);
        // System.out.println((x+1)+" "+(y+1));7
       
       
    }
}
