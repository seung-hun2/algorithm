package baekjoon;

import java.util.Scanner;

public class p6603 {

    static int[] value;
    static int k;
    static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            k = sc.nextInt();
            if(k == 0) break;
            value = new int[k];
            check = new boolean[k];

            for(int i=0;i<k;i++){
                value[i] = sc.nextInt();
            }

            recur(0,0);
            System.out.println();

        }

    }

    static void recur(int depth, int start){
        if(depth == 6){
            for(int i=0;i<k;i++){
                if(check[i]){
                    System.out.print(value[i]+ " ");
                }
            }
            System.out.println();
        }else{
            for(int i=start;i<k;i++){
                check[i] = true;
                recur(depth+1,i+1);
                check[i] = false;
            }
        }
    }

}
