import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int M, A; // 이동 시간, 충전기 개수
    static int[] moveA, moveB; // 사용자 A와 B의 이동 경로
    static Charger[] chargers; // 충전기 정보
    static int[] dy = {0, -1, 0, 1, 0}; // 이동 방향 (상, 우, 하, 좌)
    static int[] dx = {0, 0, 1, 0, -1};

    static class Charger {
        int x, y, coverage, performance;
        public Charger(int x, int y, int coverage, int performance) {
            this.x = x;
            this.y = y;
            this.coverage = coverage;
            this.performance = performance;
        }
        public boolean inRange(int px, int py) {
            return Math.abs(x - px) + Math.abs(y - py) <= coverage;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            
            moveA = new int[M + 1];
            moveB = new int[M + 1];
            chargers = new Charger[A];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }
            
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int coverage = Integer.parseInt(st.nextToken());
                int performance = Integer.parseInt(st.nextToken());
                chargers[i] = new Charger(x, y, coverage, performance);
            }
            
            int ax = 0, ay = 0, bx = 9, by = 9; // 초기 위치
            int totalCharge = 0;

            for (int time = 0; time <= M; time++) {
                ax += dx[moveA[time]];
                ay += dy[moveA[time]];
                bx += dx[moveB[time]];
                by += dy[moveB[time]];
                totalCharge += getMaxCharge(ax, ay, bx, by);
            }
            
            
            sb.append("#").append(tc).append(" ").append(totalCharge).append("\n");
        }
        System.out.print(sb);
    }

    static int getMaxCharge(int ax, int ay, int bx, int by) {
        int maxCharge = 0;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
              int chargeA = chargers[i].inRange(ax, ay) ? chargers[i].performance : 0;
              int chargeB = chargers[j].inRange(bx, by) ? chargers[j].performance : 0;            	
              // 같은 충전기 사용하는 지 검사
              // 실제로 같은 충전을 하고 있는 지 검사
              int total = (i == j && chargeA == chargeB ) ? chargeA : chargeA + chargeB;
              maxCharge = Math.max(maxCharge,total);
            }
        }
        return maxCharge;
    }
}