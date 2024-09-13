package baekjoon;

import java.util.Scanner;

public class p20437 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-->0){
            String str = sc.next();
            int K = sc.nextInt();
            if(K == 1){
                System.out.println("1 1");
                continue;
            }
            int[] arr = new int[26];
            for(int i=0;i<str.length();i++){
                arr[str.charAt(i)-'a']++;
            }
            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int i=0;i<str.length();i++){
                if(arr[str.charAt(i)-'a'] < K) continue;
                int cnt = 1;
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(i) == str.charAt(j)) cnt++;
                    if(cnt == K){
                        min = Math.min(min, j-i+1);
                        max = Math.max(max, j-i+1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) {
                System.out.println("-1");
            }else{
                System.out.println(min + " " + max);
            }
        }
    }

}
