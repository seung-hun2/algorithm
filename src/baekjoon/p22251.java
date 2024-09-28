package baekjoon;

import java.util.Scanner;

public class p22251 {

    static int ans=0;
    static int[][] building = {{1, 1, 1, 0, 1, 1, 1}, //0
        {0, 0, 1, 0, 0, 0, 1}, //1
        {0, 1, 1, 1, 1, 1, 0}, //2
        {0, 1, 1, 1, 0, 1, 1}, //3
        {1, 0, 1, 1, 0, 0, 1}, //4
        {1, 1, 0, 1, 0, 1, 1}, //5
        {1, 1, 0, 1, 1, 1, 1}, //6
        {0, 1, 1, 0, 0, 0, 1}, //7
        {1, 1, 1, 1, 1, 1, 1}, //8
        {1, 1, 1, 1, 0, 1, 1}}; //9

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N층 까지 가능
        int N = sc.nextInt();
        // K 자리 수가 보인다
        int K = sc.nextInt();
        // 최소 1 개 최대 P개를 반전 시킬 예정
        int P = sc.nextInt();
        // X층
        int X = sc.nextInt();

        solve(N,K,P,X);
        System.out.println(ans);



    }
    static int solve(int n, int k, int p, int x){
        String now = String.valueOf(x);
        while(now.length()<k){
            now = "0" + now;
        }
        for(int i=1;i<=n;i++){
            if(i==x) continue;
            String villain = String.valueOf(i);
            while(villain.length()<k){
                villain = "0" + villain;
            }
            int cnt = 0;
            for(int j=0;j<now.length();j++){
                int[] nowLED = building[now.charAt(j)-'0'];
                int[] villainLED = building[villain.charAt(j)-'0'];
                for(int m=0;m<7;m++){
                    if(nowLED[m] != villainLED[m]) cnt++;
                }
            }
            if(cnt <= p) ans++;
        }
        return ans;
    }
}
