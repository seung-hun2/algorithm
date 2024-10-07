package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p2891 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int R = sc.nextInt();

        int[] team = new int[N];
        int result = 0;
        Arrays.fill(team, 1);
        for(int i=0;i<S;i++){
            team[sc.nextInt()-1]--;
        }
        for(int i=0;i<R;i++){
            team[sc.nextInt()-1]++;
        }

        for(int i=0;i<N-1;i++){
            if(team[i] == 0 && team[i+1] == 2){
                team[i]++;
                team[i+1]--;
            }else if(team[i+1] == 0 && team[i] == 2){
                team[i+1]++;
                team[i]--;
            }
        }

        for(int i:team){
            if(i==0) result++;
        }

        System.out.println(result);

    }

}
