package baekjoon;

import java.util.Scanner;

public class p20922 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();

        int[] cnt = new int[100001];
        int start = 0;
        int end = 0;
        int ans = 0;
        while(end<arr.length){
            while(end < arr.length && cnt[arr[end]] + 1 <= K ){
                cnt[arr[end]]++;
                end++;
            }
            int len = end-start;
            ans = Math.max(len,ans);
            cnt[arr[start]]--;
            start++;
        }
        System.out.println(ans);

    }

}
