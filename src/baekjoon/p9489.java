package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p9489 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st=  new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(n==0 && k==0) break;
            int target = 0;
            int[] arr = new int[n+1];
            int[] par = new int[n+1];
            int idx = -1;
            par[0] = -1;
            arr[0] = -1;

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] == k) target = i;
                if(arr[i] != arr[i-1]+1) idx++;
                par[i] = idx;
            }

            int ans = 0;
            for(int i=1;i<=n;i++){
                if(par[i] != par[target] && par[par[i]] == par[par[target]]) ans++;
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);

    }
}
