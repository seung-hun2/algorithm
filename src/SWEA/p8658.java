package SWEA;

import java.util.Scanner;

public class p8658 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<10;i++){
                int num = sc.nextInt();
                int value = 0;
                String snum = String.valueOf(num);
                for(int j=0;j<snum.length();j++){
                    value += snum.charAt(j)-'0';
                }
                max = Math.max(max, value);
                min = Math.min(min,value);
            }

            sb.append("#").append(tc).append(" ").append(max).append(" ").append(min).append('\n');
        }
        System.out.println(sb);
    }

}
