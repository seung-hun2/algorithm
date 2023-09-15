package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N -= (N % 100);
        while (true) {
            if (N % F == 0) {
                break;
            }
            N++;
        }
        System.out.format("%02d", (N % 100));
    }


}
