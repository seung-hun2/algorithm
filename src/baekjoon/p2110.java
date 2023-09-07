package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p2110 {

    static int check(int[] arr, int m){
        int cnt = 1;
        int pastX = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-pastX >= m){
                pastX = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int ans = 0;
        int l = 1, r = arr[N-1]-arr[0];
        while(l<=r){
            int m = (l+r)/2;
            if(check(arr, m) >= C){
                ans = m;
                l = m + 1;
            }else{
                r = m -1;
            }
        }
        System.out.println(ans);
    }

}
