package SWEA;

import java.util.Scanner;

public class p5601 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int N = sc.nextInt();
            String ans = "";
            for(int i=0;i<N;i++){
                ans += "1/" + N +" " ;
            }

            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

}
