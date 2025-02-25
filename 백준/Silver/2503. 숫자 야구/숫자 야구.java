import java.io.*;
import java.util.*;

class Main {
    static int N, ans = 0;
    static boolean[] isPossible;
    static int[][] list;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(ans);
    }

    static void solve() {
        // 0 빼기
        for(int i = 123; i <= 987; i++) {
            int tmp = i;
            for(int j = 0;j<3;j++){
                if(tmp%10==0) {
                    isPossible[i] = false;
                    break;
                }
                tmp /=10;
            }
        }

        // ball strike 세기
        for(int i = 123; i <= 987; i++) {
            if(!isPossible[i]) continue;

            for(int j =0;j<N;j++){
                int s = 0, b= 0;

                String num = String.valueOf(i);
                String q = String.valueOf(list[j][0]);

                if(num.charAt(0) == num.charAt(1)
                        || num.charAt(1) == num.charAt(2)
                        ||num.charAt(2) == num.charAt(0) ){
                    isPossible[i] = false;
                    break;
                }

                for(int n1 =0;n1<3;n1++) {
                    for (int n2 = 0; n2 < 3; n2++) {
                        if (num.charAt(n1) == q.charAt(n2)) {
                            if (n1 == n2) s++;
                            else b++;
                        }
                    }
                }

                if(list[j][1]!=s || list[j][2]!=b){
                    isPossible[i] = false;
                    break;
                }
            }
        }

        for(int i = 123; i <= 987; i++) {
            if(isPossible[i]) ans++;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isPossible = new boolean[1001];
        Arrays.fill(isPossible, true);

        list = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i][2] = Integer.parseInt(st.nextToken());
        }
    }
}