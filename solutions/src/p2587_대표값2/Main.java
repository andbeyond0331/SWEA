package p2587_대표값2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		List<Double> list = new ArrayList<>();
		double sum = 0;
	    for (int cnt =0; cnt < 5; cnt++ ) {
	    	list.add((double)Integer.parseInt(br.readLine()));
	    	sum += list.get(list.size()-1);
	    }
	    
	    
	    
	   
	    list.sort(Comparator.naturalOrder());
	    
	    System.out.println(Math.round(sum/(double)5));
	    System.out.println(Math.round(list.get(list.size()/2)));
	    
	}
}
