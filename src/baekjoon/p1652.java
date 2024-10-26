package baekjoon;

import java.util.Scanner;

public class p1652 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        StringBuilder sb = new StringBuilder();
        int ans = 0 ;
        for(int i=0;i<N;i++){
            String str = sc.next();
            int cnt = 0;
            for(int j=0;j<N;j++){
                if(str.charAt(j) == '.'){
                    map[i][j] = 1;
                    cnt++;
                }else{
                    cnt = 0;
                }
                if(cnt == 2) {
                    ans++;
                }
            }
        }

        sb.append(ans).append(" ");
        ans = 0;
        for(int i=0;i<N;i++){
            int cnt = 0;
            for(int j=0;j<N;j++){
                if(map[j][i] == 1){
                    cnt++;
                }else{
                    cnt = 0;
                }

                if(cnt == 2) {
                    ans++;
                }
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }

}
