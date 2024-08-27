package baekjoon;

import java.util.Scanner;

public class p2304 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] point = new int[1001];
        int min = 1000;
        int max = 0;
        for(int i=0;i<N;i++) {
            int idx = sc.nextInt();
            int height = sc.nextInt();
            point[idx] = height;
            if(min > idx) min = idx;
            if(max < idx) max = idx;
        }

        int maxValue = point[max];
        int maxIdx = max;
        int ans = 0;
        for(int i=max-1;i>=min;i--){
            if(point[i] > maxValue){
                ans += (maxValue * (maxIdx - i));
                maxValue = point[i];
                maxIdx = i;
            }
        }


        int minIdx = min;
        int minValue = point[min];
        for(int i=min+1;i<=maxIdx;i++){
            if(point[i] > minValue){
                ans += (minValue * (i-minIdx));
                minValue = point[i];
                minIdx = i;
            }
        }

        ans += (maxIdx - minIdx + 1) * maxValue;

        System.out.println(ans);
    }

}
