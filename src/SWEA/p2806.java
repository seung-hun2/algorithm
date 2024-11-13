package SWEA;

import java.util.Scanner;

public class p2806 {
    static int[] arr;
    static int N;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++){

            cnt = 0;
            N = sc.nextInt();
            arr = new int[N];

            nQueen(0);

            sb.append("#").append(tc).append(" ").append(cnt).append('\n');
        }
        System.out.println(sb);

    }

    static void nQueen(int depth){
        if(depth == N){
            cnt++;
            return;
        }
        for(int i=0;i<N;i++){
            arr[depth] = i;
            if(poss(depth)){
                nQueen(depth+1);
            }
        }
    }

    static boolean poss(int col){
        for(int i=0;i<col;i++){
            if(arr[col] == arr[i]) return false;
            else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }
}
