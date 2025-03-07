import java.io.*;
import java.util.*;

public class Main {
    static class Balloon {
        int idx, move;

        public Balloon(int idx, int move) {
            this.idx = idx;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Balloon> dq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            dq.add(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            Balloon k = dq.removeFirst();
            sb.append(k.idx).append(" ");
            
            if (dq.isEmpty()) break;  // 마지막 요소를 제거한 경우 종료
            
            int move = k.move;
            
            if (move > 0) {
                move = (move - 1) % dq.size(); // ✅ 불필요한 연산 감소
            } else {
                move = move % dq.size();
            }

            if (move > 0) { // 오른쪽 이동
                for (int i = 0; i < move; i++) {
                    dq.addLast(dq.removeFirst());
                }
            } else { // 왼쪽 이동
                for (int i = 0; i < -move; i++) {
                    dq.addFirst(dq.removeLast());
                }
            }
        }

        System.out.println(sb.toString());
    }
}
