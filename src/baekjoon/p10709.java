package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p10709 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();

        char[][] sky = new char[H][W];
        int[][] ans = new int[H][W];
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                ans[i][j] = -1;
            }
        }

        for(int i=0;i<H;i++){
            String str = sc.next();
            for(int j=0;j<W;j++){
                sky[i][j] = str.charAt(j);
                if(sky[i][j] == 'c'){
                    ans[i][j] = 0;
                }
            }
        }

        for(int i=0;i<H;i++){
            int next = -1;
            for(int j=0;j<W;j++){
                if(ans[i][j] == 0){
                    next = 0;
                }

                if(next != -1){
                    ans[i][j] = next++;
                }
            }
        }

        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

    }

}
