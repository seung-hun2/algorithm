package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p19637 {

    static int N;
    static int[] power;
    static String[] c;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        c = new String[N];
        power = new int[N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            c[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int next = Integer.parseInt(br.readLine());
            int l = 0;
            int r = N - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (power[mid] >= next) {
                    r = mid - 1;
                } else if (power[mid] < next) {
                    l = mid + 1;
                }
            }
            sb.append(c[l]).append('\n');
        }

        System.out.println(sb);

    }
}
