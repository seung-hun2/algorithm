package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class p9017 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] score,team;
        List<Integer>[] major;
        HashMap<Integer, Integer > rank;
        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            score = new int[N+1];
            team = new int[201];
            major = new ArrayList[201];
            rank = new HashMap<>();

            for(int i=1;i<=N;i++){
                score[i] = sc.nextInt();
                team[score[i]]++;

                if(team[score[i]] == 6){
                    major[score[i]] = new ArrayList<>();
                    rank.put(score[i], 0);
                    team[score[i]] = 0;
                }
            }
            int idx = 1;
            for(int i=1;i<=N;i++){
                if(!rank.containsKey(score[i])) continue;
                if(team[score[i]] < 4){
                    rank.put(score[i], rank.get(score[i]) + idx);
                }
                major[score[i]].add(idx);
                team[score[i]]++;
                idx++;
            }

            int min = Integer.MAX_VALUE;
            int minTeam = 201;
            for(int k : rank.keySet()){
                int value = rank.get(k);

                if(min > value){
                    min = value;
                    minTeam = k;
                }else if(min == value){
                    if(major[minTeam].get(4) > major[k].get(4)) minTeam = k;
                }
            }
            sb.append(minTeam).append('\n');

        }
        System.out.println(sb);
    }

}
