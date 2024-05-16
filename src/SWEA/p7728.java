package SWEA;

import java.util.Scanner;

public class p7728 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            String str = sc.next();
            int[] arr = new int[10];
            for(int i=0;i<str.length();i++){
                arr[str.charAt(i)-'0']++;
            }
            int cnt = 0;
            for(int i=0;i<10;i++){
                if(arr[i]!=0) cnt++;
            }
            sb.append("#").append(tc).append(" ").append(cnt).append('\n');
        }
        System.out.println(sb);
    }

}
