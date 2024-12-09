import java.util.*;

class Solution {

    static class Robot {
        int r;  // 현재 행
        int c;  // 현재 열
        int[] route;  // 로봇이 따라야 할 경로 (포인트 번호)
        int currentIdx;  // 경로에서 현재 목표 포인트의 인덱스
        boolean isArrived;  // 목적지에 도달했는지 여부

        Robot(int r, int c, int[] route) {
            this.r = r;
            this.c = c;
            this.route = route;
            this.currentIdx = 0;  // 경로의 첫 번째 포인트부터 시작
            this.isArrived = false;
        }

        // 한 칸 이동하는 메서드
        void move(int[][] points) {
            if (isArrived) return;  // 이미 도달한 로봇은 이동하지 않음

            int[] targetPoint = points[route[currentIdx] - 1];  // 현재 목표 지점

            // r좌표가 목표 지점보다 작으면 증가, 크면 감소
            if (r < targetPoint[0]) {
                r++;
            } else if (r > targetPoint[0]) {
                r--;
            } else if (c < targetPoint[1]) {
                c++;
            } else if (c > targetPoint[1]) {
                c--;
            }

            // 목표 지점에 도달하면, 경로의 인덱스를 증가시킴
            if (r == targetPoint[0] && c == targetPoint[1]) {
                currentIdx++;
                if (currentIdx >= route.length) {
                    isArrived = true;  // 마지막 목적지에 도달했으면 도착 표시
                }
            }
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        // 로봇 초기화
        List<Robot> robots = new ArrayList<>();
        for (int[] route : routes) {
            int[] robotRoute = Arrays.copyOf(route, route.length);
            int startPoint = robotRoute[0] - 1;  // 시작점 번호
            robots.add(new Robot(points[startPoint][0], points[startPoint][1], robotRoute));
        }

        // 각 로봇이 이동할 때마다 충돌을 체크
        while (true) {
            // 로봇들이 이동한 후 각 좌표를 기록
            Map<String, Integer> positionMap = new HashMap<>();
            
            // 로봇 이동
            for (Robot robot : robots) {
                if (!robot.isArrived) {
                    robot.move(points);  // 로봇 이동
                    String position = robot.r + "," + robot.c;
                    positionMap.put(position, positionMap.getOrDefault(position, 0) + 1);  // 위치별 로봇 수 카운트
                }
            }

            // 충돌이 발생한 경우, 해당 위치에서 두 개 이상의 로봇이 존재하면 충돌
            int collisionCount = 0;
            for (int count : positionMap.values()) {
                if (count > 1) {
                    collisionCount++;  // 충돌 발생
                }
            }

            // 충돌이 발생했으면 해당 횟수만큼 추가
            if (collisionCount > 0) {
                answer += collisionCount;
            }

            // 모든 로봇이 목적지에 도달했으면 종료
            boolean allArrived = true;
            for (Robot robot : robots) {
                if (!robot.isArrived) {
                    allArrived = false;
                    break;
                }
            }

            if (allArrived) break;  // 모든 로봇이 목적지에 도달하면 종료
        }

        return answer;
    }
}
