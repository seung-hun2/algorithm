package baekjoon;

import java.util.Scanner;

public class p2979 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[101];
        for(int i=0;i<3;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            for(int j=start;j<end;j++){
                arr[j]++;
            }

        }
        int ans = 0;
        for(int i=0;i<=100;i++){
            if(arr[i] == 1) ans += A;
            else if(arr[i] == 2) ans += B*2;
            else if(arr[i] == 3) ans += C*3;
        }
        System.out.println(ans);
    }

}
