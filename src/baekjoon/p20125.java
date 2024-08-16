package baekjoon;

import java.util.Scanner;

public class p20125 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        int[] first = new int[2];
        boolean check = false;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            String str = sc.next();
            for(int j=0;j<N;j++){
                if(str.charAt(j) == '_') map[i][j] = 0;
                else if(str.charAt(j) == '*') {
                    map[i][j] = 1;
                    if(!check){
                        first[0] = j;
                        first[1] = i;
                        check = true;
                    }
                }
            }
        }
        first[1] += 1;
        sb.append(first[1]+1).append(" ").append(first[0]+1).append('\n');

        // 왼팔 오른팔 허리 왼다 오다
        int cnt = 0;
        for(int i=first[0]-1;i>=0;i--){
            if(map[first[1]][i] == 1) cnt++;
            else break;
        }
        sb.append(cnt).append(" ");

        cnt = 0;
        for(int i=first[0]+1;i<N;i++){
            if(map[first[1]][i] == 1) cnt++;
            else break;
        }
        sb.append(cnt).append(" ");

        int lastY = 0;
        cnt = 0;
        for(int i=first[1]+1;i<N;i++){
            if(map[i][first[0]] == 1) cnt++;
            else {
                // 허리 마지막 다음 위치 저장해야함
                lastY = i;
                break;
            }
        }
        sb.append(cnt).append(" ");

        cnt = 0;
        for(int i=lastY;i<N;i++){
            if(map[i][first[0]-1] == 1) cnt++;
            else break;
        }
        sb.append(cnt).append(" ");

        cnt = 0;
        for(int i=lastY;i<N;i++){
            if(map[i][first[0]+1] == 1) cnt++;
            else break;
        }
        sb.append(cnt).append(" ");

        System.out.println(sb);
    }

}
