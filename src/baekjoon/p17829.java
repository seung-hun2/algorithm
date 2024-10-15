package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p17829 {

    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        map = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(recur(0,0,N));
    }

    static int recur(int i, int j, int size){
        if(size == 2){
            int[] arr= new int[4];
            int idx = 0;
            for(int r=i;r<i+2;r++){
                for(int c=j;c<j+2;c++){
                    arr[idx++] = map[r][c];
                }
            }
            Arrays.sort(arr);
            return arr[2];
        }
        else{
            int[] arr = new int[4];
            size /= 2;
            arr[0] = recur(i,j,size);
            arr[1] = recur(i,j+size,size);
            arr[2] = recur(i+size,j,size);
            arr[3] = recur(i+size,j+size,size);

            Arrays.sort(arr);
            return arr[2];
        }
    }

}
