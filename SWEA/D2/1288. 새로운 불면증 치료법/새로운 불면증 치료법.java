import java.util.*;
import java.io.*;

public class Solution {
    static int check,ans; static int total = (1<<10)-1;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());
            check =0;
            dfs(0,N);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int depth, int num){
        int tmp = num;
        while(tmp !=0 ){
            check = check|(1<<tmp%10);
            tmp/=10;
        }
        if(check == total) {
            ans = num;
            return;
        }
        dfs(depth+1,N*(depth+1));
    }
}