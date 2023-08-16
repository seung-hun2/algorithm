package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3085 {
    public static void swap(char[][] arr, int r1, int c1, int r2, int c2){
        char temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }
    public static int maxRow(char[][] arr){
        int maxRow = 0;
        for(int r=0;r<arr.length;r++){
            int len = 1;
            for(int c=1;c<arr.length;c++){
                if(arr[r][c] == arr[r][c-1]) len++;
                else{
                    maxRow = Math.max(maxRow,len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }
        return maxRow;
    }
    public static int maxColumn(char[][] arr){
        int maxColum = 0;
        for(int c=0;c<arr.length;c++){
            int len = 1;
            for(int r=1;r<arr.length;r++){
                if(arr[r][c] == arr[r-1][c]) len++;
                else{
                    maxColum = Math.max(maxColum,len);
                    len = 1;
                }
            }
            maxColum = Math.max(maxColum, len);
        }
        return maxColum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++){
            arr[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j+1 < n && arr[i][j] != arr[i][j+1]){
                    swap(arr,i,j,i,j+1);
                    ans = Math.max(ans, Math.max(maxColumn(arr), maxRow(arr)));
                    swap(arr,i,j,i,j+1);
                }
                if(i+1 < n && arr[i][j] != arr[i+1][j]){
                    swap(arr,i,j,i+1,j);
                    ans = Math.max(ans, Math.max(maxColumn(arr), maxRow(arr)));
                    swap(arr,i,j,i+1,j);
                }
            }
        }
        System.out.println(ans);

    }

}
