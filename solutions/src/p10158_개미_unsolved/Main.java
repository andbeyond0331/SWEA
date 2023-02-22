package p10158_개미_unsolved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		// 가로
		int w = Integer.parseInt(st.nextToken());
		// 세로
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		// 출발 위치
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		// 움직일 시간
		int time = Integer.parseInt(br.readLine());
		int t = time;
		int dr = +1;
		int dc = +1;
		int firstDr = +1;
		int firstDc = +1;
		int firstP = p;
		int firstQ = q;
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(t>0) {
			p+=dr;
			q+=dc;
			if(firstP == p && firstQ == q && firstDr == dr && firstDc == dc) {
				count = time-t;
				t = t%count;
			}
			
			if(p<0 || p>w || q<0 || q>h) {
				p-=dr;
				q-=dc;
				
				if(p==0) {
					if(q==0) {
						dr = +1;
						dc = +1;
					}else if(q==h){
						dr = +1;
						dc = -1;
					}else {
						if(dr==-1 && dc == -1) {
							dr = +1;
							dc = -1;
						}else if(dr==-1 && dc == +1) {
							dr = +1;
							dc = +1;
						}else {
							System.out.println("Strange1");
						}
					}
				}else if(p==w) {
					if(q==0) {
						dr = -1;
						dc = +1;
					}else if(q==h) {
						dr = -1;
						dc = -1;
					}else {
						if(dr==+1 && dc==+1) {
							dr = -1;
							dc = +1;
						}else if(dr == +1 && dc == -1) {
							dr = -1;
							dc = -1;
							
						}
					}
				}else {
					if(q==0) {
						if(dr == -1 && dc == -1) {
							dr = -1;
							dc = +1;
						}else if(dr==+1 && dc==-1){
							dr = +1;
							dc = +1;
						}
					}else if(q==h) {
						if(dr == +1 && dc == +1) {
							dr = +1;
							dc = -1;
						}else if(dr == -1 && dc == +1) {
							dr = -1;
							dc = -1;
						}
					}else {
						// 그대로
						
					}
				}
				
			}else {
				t--;
			}
			
			
		}
		
		sb.append(p);
		sb.append(" ");
		sb.append(q);
		
		bw.append(sb);
		bw.flush();
		br.close();
		bw.close();
	}
}
