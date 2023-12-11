package baekjoon;

import java.util.Scanner;

public class p9466 {

    static int[] nextNode;
    static int[] depth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            nextNode = new int[N + 1];
            depth = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                nextNode[i] = sc.nextInt();
                depth[i] = 0;
            }

            int cnt = 0;
            for (int i=1;i<=N;i++){
                if(depth[i] == 0 ){
                    depth[i] = 1;
                    cnt += dfs(i);
                }
            }
            System.out.println(N-cnt);
        }
    }

    static int dfs(int nodeNum) {
        int next = nextNode[nodeNum];
        int cycleCnt = 0;
        // 첫 방문
        if (depth[next] == 0) {
            depth[next] = depth[nodeNum] + 1;
            cycleCnt = dfs(next);
        }
        // 재방문
        else {
            cycleCnt = depth[nodeNum] - depth[next] + 1;
        }
        // 다음 탐색을 위해 재귀 안에서 초기화
        depth[nodeNum] = 100001;
        return cycleCnt < 0 ? 0 : cycleCnt;
    }
}
