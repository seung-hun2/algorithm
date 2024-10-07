package baekjoon;

import java.util.Scanner;

public class p2885 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int n = 1;
        int cnt = 0;
        while(n<K) n *= 2;
        StringBuilder sb= new StringBuilder();
        sb.append(n).append(" ");

        while(K>0){
            if(K>=n){
                K-=n;
            }else{
                n/=2;
                cnt++;
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }

}
