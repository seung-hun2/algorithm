package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] arr = new int[20];
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            sb.append(st.nextToken()).append(" ");
            int cnt = 0;
            for(int j=0;j<20;j++){
                arr[j] = Integer.parseInt(st.nextToken());
                for(int k=0;k<j;k++){
                    if(arr[k] > arr[j]) cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

}
