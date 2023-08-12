package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[n];
        int answer = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        boolean[] exist = new boolean[1000001];
        for(int i=0;i<n;i++){
            exist[arr[i]] = true;
        }
        for(int i=1;i<=(x-1)/2;i++){
            if(i<=1000000 && x-i<=1000000){
                answer += (exist[i] && exist[x-i]) ? 1:0;
            }
        }
        System.out.println(answer);

    }

}
