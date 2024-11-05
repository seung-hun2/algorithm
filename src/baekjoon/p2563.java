package baekjoon;

import java.util.Scanner;

public class p2563 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[101][101];
        for(int i=0;i<N;i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            for(int j=r;j<r+10;j++){
                for(int k=c;k<c+10;k++){
                    map[j][k]++;
                }
            }
        }
        int ans = N * 100;
        for(int i=1;i<101;i++){
            for(int j=1;j<101;j++){
                if(map[i][j] > 1){
                    ans -= map[i][j]-1;
                }
            }
        }
        System.out.println(ans);
    }

}
