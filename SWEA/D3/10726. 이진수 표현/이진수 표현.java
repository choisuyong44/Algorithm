import java.util.*;
import java.io.*;

public class Solution {
    static boolean isOn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            isOn = true;
            for(int i=0;i<N;i++) {
                if((M & (1<<i)) ==0){
                    isOn = false;
                    break;
                }
            }
            if(isOn) sb.append("#").append(tc).append(" ").append("ON").append("\n");
            else sb.append("#").append(tc).append(" ").append("OFF").append("\n");
        }
        System.out.println(sb.toString());
    }

}