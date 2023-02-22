package p1550_16진수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String str = br.readLine();
			int n = 16;
			int idx = str.length()-1;
			int result = 0;
			for (int i = 0; i < str.length(); i++) {
				switch (str.charAt(i)) {
				case '0':
					result+=0;
					break;
				case '1' :
					result+=Math.round(Math.pow(n, idx));
				}
				idx--;
					
			}
			
		}
	
}
