package SWEA;

import java.util.Scanner;

public class p6730 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int N =sc.nextInt();
            int[] arr = new int[N];
            int up = 0;
            int down = 0;

            for(int i=0;i<N;i++){
                arr[i] = sc.nextInt();
                if(i!=0){
                    int diff = arr[i]-arr[i-1];
                    if(diff<0){
                        down = Math.max(down, Math.abs(diff));
                    }else{
                        up = Math.max(up, Math.abs(diff));
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(up+" "+down).append('\n');
        }
        System.out.println(sb);
    }

}
