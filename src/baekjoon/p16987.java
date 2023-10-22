package baekjoon;

import java.util.Scanner;

public class p16987 {

    static class Egg{
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        public void fight(Egg other){
            this.durability -= other.weight;
            other.durability -= this.weight;
        }

        public void restore(Egg other){
            this.durability += other.weight;
            other.durability += this.weight;
        }
    }

    static Egg[] eggs;
    static int N,answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        eggs = new Egg[N];
        for(int i=0;i<N;i++){
            eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
        }

        solve(0);
        System.out.println(answer);
    }

    public static void solve(int pick){
        // base case
        if(pick == N){
            int cnt = 0;
            for(int i=0;i<N;i++){
                if(eggs[i].durability <= 0){
                    cnt++;
                }
            }
            answer = Math.max(answer,cnt);
            return;
        }

        // recursive case
        if(eggs[pick].durability>0){
            boolean check = false;
            for(int i=0;i<N;i++){
                if(pick==i) continue;
                if(eggs[i].durability>0){
                    check = true;
                    eggs[pick].fight(eggs[i]);
                    solve(pick+1);
                    eggs[pick].restore(eggs[i]);
                }
            }
            if(!check) solve(pick+1);
        }else{
            solve(pick+1);
        }


    }
}
