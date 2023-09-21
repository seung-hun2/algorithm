package baekjoon;

import java.util.Scanner;

public class p2503 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] q = new int[N][3];
        for (int i = 0; i < N; i++) {
            q[i][0] = sc.nextInt();
            q[i][1] = sc.nextInt();
            q[i][2] = sc.nextInt();

        }
        int ans = 0;

        for (int x = 1; x <= 9; x++) {
            for (int y = 1; y <= 9; y++) {
                for (int z = 1; z <= 9; z++) {
                    if (x == y || y == z || z == x) {
                        continue;
                    }
                    boolean check = true;
                    for (int i = 0; i < N; i++) {
                        int qx = q[i][0] / 100;
                        int qy = (q[i][0] / 10) % 10;
                        int qz = q[i][0] % 10;

                        int strike = 0, ball = 0;
                        if (qx == x) {
                            strike++;
                        } else if (qx == y || qx == z) {
                            ball++;
                        }
                        if (qy == y) {
                            strike++;
                        } else if (qy == x || qy == z) {
                            ball++;
                        }
                        if (qz == z) {
                            strike++;
                        } else if (qz == x || qz == y) {
                            ball++;
                        }
                        if (q[i][1] != strike || q[i][2] != ball) {
                            check = false;
                            break;
                        }
                    }
                    if(check) ans++;
                }
            }
        }

        System.out.println(ans);
    }

}
