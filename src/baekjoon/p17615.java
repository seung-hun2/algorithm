package baekjoon;

import java.util.Scanner;

public class p17615 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] ch = sc.next().toCharArray();

        int cnt = Integer.MAX_VALUE;
        int next = 0;
        boolean check = false;
        for(int i=0;i<N;i++){
            if(check && ch[i] == 'R'){
                next++;
                continue;
            }
            if(ch[i]=='B') check = true;
        }
        cnt = Math.min(cnt, next);

        next = 0;
        check = false;
        for(int i=0;i<N;i++){
            if(check && ch[i] == 'B'){
                next++;
                continue;
            }
            if(ch[i]=='R') check = true;
        }
        cnt = Math.min(cnt, next);


        next = 0;
        check = false;
        for(int i=N-1;i>=0;i--){
            if(check && ch[i] == 'B'){
                next++;
                continue;
            }
            if(ch[i]=='R') check = true;
        }
        cnt = Math.min(cnt, next);


        next = 0;
        check = false;
        for(int i=N-1;i>=0;i--){
            if(check && ch[i] == 'R'){
                next++;
                continue;
            }
            if(ch[i]=='B') check = true;
        }
        cnt = Math.min(cnt, next);

        System.out.println(cnt);
    }

}
