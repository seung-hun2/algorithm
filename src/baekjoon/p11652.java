package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p11652 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr,1,N+1);
        long mode = arr[1];
        int modeCnt = 1, curCnt = 1;

        for(int i=2;i<=N;i++){
            if(arr[i] == arr[i-1] ){
                curCnt++;
            }else{
                curCnt = 1;
            }
            if(modeCnt < curCnt){
                modeCnt = curCnt;
                mode = arr[i];
            }
        }

        System.out.println(mode);

    }

}
