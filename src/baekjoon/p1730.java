package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1730 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean [][] vertical = new boolean[n][n];
        boolean [][] horizontal = new boolean[n][n];
        int curR = 0, curC = 0;

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char cmd = str.charAt(i);
            if (cmd == 'D') {
                if(curR == n-1) continue;
                vertical[curR][curC] = vertical[curR+1][curC] = true;
                curR++;
            } else if (cmd == 'U') {
                if(curR == 0) continue;
                vertical[curR][curC] = vertical[curR-1][curC] = true;
                curR--;
            } else if (cmd == 'L') {
                if(curC == 0) continue;
                horizontal[curR][curC] = horizontal[curR][curC-1] = true;
                curC--;
            } else {
                if(curC == n-1) continue;
                horizontal[curR][curC] = horizontal[curR][curC+1] = true;
                curC++;
            }
        }

        for(int i=0;i<n;i++){
            String ans = "";
            for(int j=0;j<n;j++){
                if(vertical[i][j] && horizontal[i][j]) ans += "+";
                else if(vertical[i][j]) ans += "|";
                else if(horizontal[i][j]) ans += "-";
                else ans += ".";
            }
            System.out.println(ans);
        }


    }

}
