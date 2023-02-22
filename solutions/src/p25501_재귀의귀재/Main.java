package p25501_재귀의귀재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc ++) {
			count = 0;
			System.out.printf(isPalindrome(br.readLine())+" "+count+"\n");
		}
//		System.out.printf("ABBA: %d\n", isPalindrome("ABBA"));
//		System.out.printf("ABC: %d\n", isPalindrome("ABC"));
	}
	
	static int recursion(String s, int l, int r) {
		count++;
		if(l >= r) return 1;
		else if (s.charAt(l)!=s.charAt(r)) return 0;
		else {
			
			return recursion(s, l+1, r-1);
		}
	}
	
	static int isPalindrome(String s) {
		return recursion(s, 0, s.length()-1);
	}
	
	
}
