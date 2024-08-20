package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visit = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            visit[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0;i<X;i++) sum += visit[i];

        int max = sum;
        int cnt = 1;
        for(int i=X;i<N;i++){
            sum += visit[i] - visit[i-X];
            if(max == sum) cnt++;
            else if(max < sum){
                cnt = 1;
                max = sum;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }

}
