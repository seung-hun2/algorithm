package baekjoon;

import java.util.Scanner;

public class p2607 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int[] arr = new int[26];
        int ans = 0;
        for(int i=0;i<N-1;i++){
            int cnt = 0;

            for(int j=0;j<str.length();j++){
                arr[str.charAt(j)-'A']++;
            }

            String next = sc.next();
            for(int j=0;j<next.length();j++){
                if(arr[next.charAt(j)-'A'] >0){
                    cnt++;
                    arr[next.charAt(j)-'A']--;
                }
            }

            if(str.length() == next.length() && (str.length() == cnt || str.length() -1 == cnt)){
                ans++;
            }else if(str.length() == next.length()-1 && next.length()-1 == cnt){
                ans++;
            }else if(str.length() == next.length()+1 && next.length() == cnt){
                ans++;
            }
        }

        System.out.println(ans);
    }


}
