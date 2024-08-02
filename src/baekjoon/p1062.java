package baekjoon;

import java.util.Scanner;

public class p1062 {

    static int N,K,ans;
    static String[] data;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int mask = 0 ;
        mask |= 1<<(int)'a'-'a'+1;
        mask |= 1<<(int)'c'-'a'+1;
        mask |= 1<<(int)'i'-'a'+1;
        mask |= 1<<(int)'n'-'a'+1;
        mask |= 1<<(int)'t'-'a'+1;

        data = new String[N];
        for(int i=0;i<N;i++){
            String next = sc.next();
            next = next.replaceAll("[a,c,i,n,t]","");
            data[i] = next;
        }

        solve(0,5,mask);
        System.out.println(ans);

    }

    static void solve(int idx, int cnt, int mask){
        if(cnt == K){
            int can = 0;
            for(int i=0;i<N;i++){
                boolean check = true;
                for(int j=0;j<data[i].length();j++){
                    if((mask & (1<< data[i].charAt(j) - 'a'+1)) == 0){
                        check = false;
                        break;
                    }
                }
                if(check) can++;
            }
            ans = Math.max(ans, can);
            return;
        }

        for(int i=idx;i<=26;i++){
            if((mask&(1<<i)) == 0){
                solve(i+1, cnt+1, mask | (1<<i));
            }
        }
    }

}
