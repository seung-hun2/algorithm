package baekjoon;

import java.util.Scanner;

public class p5525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String S = sc.next();
        int cnt = 0, ans = 0;
        for(int i=1;i<M-1;i++){
            if(S.charAt(i-1)=='I'&&S.charAt(i)=='O' && S.charAt(i+1) == 'I') {
                cnt++;
                if (cnt == N) {
                    cnt--;
                    ans++;
                }
                i++;
            }else{
                cnt =0;
            }
        }
        System.out.println(ans);
    }

}
