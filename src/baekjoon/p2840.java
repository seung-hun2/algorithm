package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2840 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        char[] arr = new char[N];
        Arrays.fill(arr, '?');
        int status = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int step = Integer.parseInt(st.nextToken());
            int next = ((status - step) % N + N) % N;
            char nextAlphabet = st.nextToken().charAt(0);
            if (arr[next] == '?') {
                arr[next] = nextAlphabet;
            } else if (arr[next] != nextAlphabet) {
                System.out.println("!");
                return;
            }
            status = next;
        }
        boolean[] used = new boolean[26];
        for (int i = 0; i < N; i++) {
            if(arr[i] == '?') continue;
            if (used[arr[i] - 'A']) {
                System.out.println("!");
                return;
            }
            used[arr[i] - 'A'] = true;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[(status + i) % N]);
        }


    }

}
