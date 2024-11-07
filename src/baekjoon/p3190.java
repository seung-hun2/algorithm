package baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class p3190 {

    static int N, K;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N + 1][N + 1];
        Deque<int[]> snake = new ArrayDeque<>();
        HashMap<Integer, String> hashMap = new HashMap<>();

        for (int i = 0; i < K; i++) {
            map[sc.nextInt()][sc.nextInt()] = 1;
        }

        int L = sc.nextInt();
        for (int i = 0; i < L; i++) {
            hashMap.put(sc.nextInt(), sc.next());
        }

        int now_x = 1;
        int now_y = 1;
        int now_dir = 0;
        int t = 0;

        snake.add(new int[]{1, 1});
        map[1][1] = -1;

        while (true) {
            t++;
            // 몸 길이 늘려 머리를 다음칸에 위치 시키기
            now_x += dx[now_dir];
            now_y += dy[now_dir];

            // 벽이나 몸에 데이는 것 체크
            if (now_x < 1 || now_x > N || now_y < 1 || now_y > N || map[now_x][now_y] == -1) {
                break;
            }

            // 사과가 있다면, 그 칸에 사과를 없애고 몸길이 늘리기
            if (map[now_x][now_y] == 1) {
                map[now_x][now_y] = 0;
            }
            // 사과가 없다면, 몸 길이를 줄여, 꼬리가 위치한 칸을 비워준다.
            else{
                int[] rem = snake.poll();
                map[rem[0]][rem[1]] = 0;
            }
            snake.add(new int[]{now_x, now_y});
            map[now_x][now_y] = -1;

            if(hashMap.containsKey(t)){
                String change = hashMap.get(t);
                if(change.equals("L")){
                    now_dir = (now_dir + 3) % 4;
                } else {
                    now_dir = (now_dir + 1) % 4;
                }
            }

        }

        System.out.println(t);

    }

}
