package baekjoon;

import java.util.Scanner;

public class p17266 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        int maxDif = 0;
        for(int i=0;i<M;i++){
            arr[i] = sc.nextInt();
            if(i != 0) {
                int dif = arr[i] - arr[i-1];
                if(dif%2 == 0){
                    maxDif = Math.max(dif/2, maxDif);
                }else{
                    maxDif = Math.max(dif/2+1, maxDif);
                }
            }
        }

        maxDif = Math.max(maxDif, Math.max(arr[0], N-arr[M-1]));

        System.out.println(maxDif);

    }

}
