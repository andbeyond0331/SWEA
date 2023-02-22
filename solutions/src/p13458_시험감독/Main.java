package p13458_시험감독;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] As = new int[N];
		for (int i = 0; i < As.length; i++) {
			As[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		long count = 0;
		
		for (int i = 0; i < As.length; i++) {
			As[i]-= B;
			if(As[i]>0) {
				if(As[i]%C!=0) {
					count+=As[i]/C+1;
				}else {
					count+=As[i]/C;
				}
			}
			
			count++;
		}
		System.out.println(count);
		
	}
}
