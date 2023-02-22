package d2.p1859_백만장자프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] prices;
	static long sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb =new StringBuffer();
	
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			prices = new int[N];
			
			int max = 0;
			int maxIdx = 0;
			
			sum = 0;
			
			for(int nums = 0; nums < N; nums++) {
				prices[nums] = Integer.parseInt(st.nextToken());
				if(max<prices[nums]) {
					max = prices[nums];
					maxIdx = nums;
				}
			}
			
			returnSumLeft(0, maxIdx);
			returnSumRight(maxIdx+1, prices.length-1);
			
			System.out.println("#" + (testCase+1) + " " + sum);
			
		}
	}
	
	public static int returnSumRight(int startIdx, int maxIdx) {
		
		if(Math.abs(startIdx-maxIdx)<1) {
			return 0;
		}
		int maxAmount = 0;
		int tempMaxIdx =0;
		for(int num = startIdx; num <= maxIdx; num++) {
			if(prices[num]>maxAmount) {
				maxAmount = prices[num];
				tempMaxIdx = num;
			}
		}
		
		if(tempMaxIdx>startIdx) {
			returnSumLeft(startIdx, tempMaxIdx);
			if(tempMaxIdx<prices.length-1) {
				
				returnSumRight(tempMaxIdx+1, prices.length-1);
			}
		}else if(tempMaxIdx == startIdx) {
			if(tempMaxIdx<prices.length-1) {
				returnSumRight(tempMaxIdx+1, prices.length-1);
			}
		}
		
		return 0;
		
		
		
		
	}
	
	
	public static long returnSumLeft(int startIdx, int maxIdx) {
		long temp = 0;
		int maxAmount = prices[maxIdx];
		for(int idx = startIdx; idx <= maxIdx; idx++) {
			temp+= maxAmount-prices[idx];
		}
		
		sum+=temp;
		
		
		return temp;
	}
	
	
	
	
}
