package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p13144 {

    static int N;
    static long ans;
    static int[] arr,cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cnt = new int[100001];
        toPoint();

        System.out.println(ans);


    }

    static void toPoint(){
        ans = 0L;
        for(int L=1,R=0;L<=N;L++){
            while(R+1<=N && cnt[arr[R+1]] == 0){
                R++;
                cnt[arr[R]]++;
            }
            ans += R-L+1;

            cnt[arr[L]]--;
        }
    }

}
