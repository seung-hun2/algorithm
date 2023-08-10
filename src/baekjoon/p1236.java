package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j] = str.charAt(j);
            }
        }
        int row_cnt = 0;
        int col_cnt = 0;

        for(int i=0;i<n;i++){
            boolean exist = false;

            for(int j=0;j<m;j++){
                if(arr[i][j] == 'X'){
                    exist = true;
                    break;
                }
            }
            if(exist) row_cnt++;
        }

        for(int i=0;i<m;i++){
            boolean exist = false;
            for(int j=0;j<n;j++) {
                if (arr[j][i] == 'X') {
                    exist = true;
                    break;
                }
            }
            if(exist) col_cnt++;
        }

        System.out.println(Math.max(m-col_cnt,n-row_cnt));




    }

}
