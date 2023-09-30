package baekjoon;

import java.util.Scanner;

public class p10799 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();
        int cnt = 0;
        int ans = 0;
        for(int i=0;i<input.length;i++){
            if(input[i] == '(') cnt++;
            else{
                cnt--;
                if(input[i-1]=='(') ans += cnt;
                else ans++;
            }
        }
        System.out.println(ans);
    }

}
