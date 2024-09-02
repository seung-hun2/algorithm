package baekjoon;

import java.util.Scanner;

public class p2531 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초밥의 가짓수를 최대로 해야한다.
        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0;i<N;i++) arr[i] = sc.nextInt();

        int[] num = new int[d+1];

        for(int i=0;i<k;i++) {
            num[arr[i]]++;
        }
        num[c]++;

        int ans = 0;
        for(int i=0;i<=d;i++) {
            if(num[i] != 0 ){
                ans++;
            }
        }

        for(int i=k;i<N;i++){
            num[arr[i-k]]--;
            num[arr[i]]++;
            int cnt = 0;
            for(int j=0;j<=d;j++) {
                if(num[j] != 0 ) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }

        for(int i=0;i<k;i++){
            int idx = N+i;
            num[arr[idx-k]]--;
            num[arr[i]]++;
            int cnt = 0;
            for(int j=0;j<=d;j++) {
                if(num[j] != 0 ) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }


        System.out.println(ans);
    }

}
