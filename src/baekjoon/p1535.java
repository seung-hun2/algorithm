package baekjoon;


import java.util.Scanner;

public class p1535 {

    static int ans = 0;
    static int N;
    static int[][] person;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        N = sc.nextInt();
        person = new int[N][2];

        for(int i=0;i<N;i++){
            person[i][0] = sc.nextInt();
        }
        for(int i=0;i<N;i++){
            person[i][1] = sc.nextInt();
        }


        solve(100,0,0);
        System.out.println(ans);


    }
    static void solve(int nowHealth, int nowHappy, int idx){
        if(nowHealth < 1) return;

        ans = Math.max(nowHappy, ans);

        if(idx == N) return;

        solve(nowHealth, nowHappy, idx+1);
        solve(nowHealth - person[idx][0], nowHappy + person[idx][1], idx+1);



    }

}
