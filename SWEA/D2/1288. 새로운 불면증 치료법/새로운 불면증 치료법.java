import java.util.*;
import java.io.*;

public class Solution {
    static int check,ans; 
    static int total = (1<<10)-1;
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            N = Long.parseLong(br.readLine());
            check =0;
            dfs(0,N);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int depth, long num){
        long tmp = num;

        // while 각자리수 분리
        //      비트마스킹
        while(tmp !=0 ){
            // 10인 경우 예외처리
            if(tmp == 10){
                check = check|1;
                check = check|(1<<1);
                break;
            }
            check = check|(1<<tmp%10);
            tmp/=10;
        }

        if(check == total) {
            ans = (int)num;
            return;
        }
        // dfs
        dfs(depth+1,N*(depth+1));
    }
}