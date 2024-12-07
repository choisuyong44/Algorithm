import java.util.*;
import java.io.*;

public class Main {
    static int H,W;
    static int start, end;
    static int[] width;
    
    public static void main(String[] args) throws IOException{
        input();
        int ans = 0;
        start = 0; end = findMaxEndIdx(start);
        while (start < W-1 && end < W) {
        	if(width[start] >= width[end]) {
        		for(int i =start+1; i<end;i++) {
        			ans += width[end] - width[i];
        		}
        	}
        	
        	else {
        		for(int i =start+1; i<end;i++) {
        			ans += width[start] - width[i];
        		}        		
        	}
        	
        	start = end;
        	end = findMaxEndIdx(start);
        }
        
        System.out.println(ans);
    }
    
    public static int findMaxEndIdx(int start) {
    	int maxEndIdx = start+1;
    	for(int i =start+1;i<W;i++){
    		if(width[start] <= width[i]) {
    			return i;
    		}
    		else {
    			if(width[maxEndIdx] < width[i]) {
    				maxEndIdx = i;
    			}
    		}
    	}
    	return maxEndIdx;
    }

    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        width = new int[W];
        
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<W;i++){
            width[i] = Integer.parseInt(st.nextToken());
        }
    }
}