import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// K * L

public class Main {
    static int N, M, L, K;
    static int ans;
    static int[][] stars;
    
    public static void main(String[] args) throws IOException {
        input();
        ans = 0;

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int startX = stars[i][0];
                int startY = stars[j][1];
                ans = Math.max(ans, countStars(startX, startY));
            }
        }

        System.out.println(K-ans);
    }

    public static int countStars(int x, int y) {
        int count = 0;

        for (int i = 0; i < K; i++) {
            if (x <= stars[i][0] && stars[i][0] <= x + L &&
                y <= stars[i][1] && stars[i][1] <= y + L) {
                count++;
            }
        }

        return count;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}