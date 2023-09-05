package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p2470 {

    static int findOptimalPairValue(int[] arr, int fromIndex, int toIndex, int value){
        int optimalPairValue = 0;
        int optimalPairAbs = 2000000000;

        int l = fromIndex, r = toIndex;
        while (l<=r){
            int m = (l+r)/2;
            int sum = value + arr[m];
            int sumAbs = Math.abs(sum);
            if(sumAbs < optimalPairAbs){
                optimalPairValue = arr[m];
                optimalPairAbs = sumAbs;
            }
            if(sum<0) l = m +1;
            else if(sum>0) r = m-1;
            else return arr[m];
        }
        return optimalPairValue;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 2000000000;
        int first = -1;
        int second = -1;
        Arrays.sort(arr);
        for(int i=0;i<N-1;i++){
            int pairValue = findOptimalPairValue(arr, i+1, N-1, arr[i]);
            int abs = Math.abs(arr[i] + pairValue);
            if(abs < ans){
                ans = abs;
                first = arr[i];
                second = pairValue;
            }
        }


        System.out.println(first + " " + second);
    }

}
