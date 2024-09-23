package baekjoon;

import java.util.Scanner;

public class p7682 {

    static char[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true){
            String next = sc.next();
            if(next.equals("end")){
                break;
            }
            map = new char[3][3];
            char[] chars = next.toCharArray();
            int oCnt = 0, xCnt = 0, idx=0;
            // 개수 체크
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    map[i][j] = next.charAt(idx++);
                    if(map[i][j] == 'O') oCnt++;
                    else if(map[i][j] == 'X') xCnt++;
                }
            }

            if(xCnt == oCnt+1){
                if(xCnt + oCnt == 9 && !bingo('O')){
                    sb.append("valid").append('\n');
                }else if(!bingo('O') && bingo('X')){
                    sb.append("valid").append('\n');
                }else{
                    sb.append("invalid").append('\n');
                }
            }else if(xCnt == oCnt){
                if(!bingo('X') && bingo('O')){
                    sb.append("valid").append('\n');
                }else{
                    sb.append("invalid").append('\n');
                }
            }else{
                sb.append("invalid").append('\n');
            }

        }
        System.out.println(sb);
    }
    public static boolean bingo(char c) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == c && map[i][1] == c && map[i][2] == c) {
                return true;
            }
        }
        // 세로
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == c && map[1][i] == c && map[2][i] == c) {
                return true;
            }
        }
        // 대각선
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }

        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) {
            return true;
        }

        return false;
    }

}
