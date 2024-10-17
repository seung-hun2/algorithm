package baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class p2852 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node node= new Node(0,0,0);
        int teamA = 0, teamB = 0;

        int time = 0;
        for(int i=0;i<N;i++){
            int team = sc.nextInt();
            String str = sc.next();
            StringTokenizer st = new StringTokenizer(str,":");

            time = Integer.valueOf(st.nextToken())*60 + Integer.valueOf(st.nextToken());
            if(node.team == 0){
                node = new Node(team,time,1);
            }else{
                // 다른 팀일 때
                if(node.team != team){
                    if(node.score-1 == 0){
                        if(node.team == 1){
                            teamA += time - node.time;
                            node.time = time;
                        }else{
                            teamB += time - node.time;
                            node.time = time;
                        }
                        node.team = 0;
                        node.score = 0;
                    }else{
                        node.score--;
                    }
                }else{
                    node.score++;
                }
            }
        }
        if(node.score!=0){
            if(node.team == 1){
                teamA += 2880 - node.time;
            }else{
                teamB += 2880 - node.time;
            }
        }

        String AH = "", AM = "", BH ="", BM = "";
        if(teamA == 0 ){
            AH="00";
            AM="00";
        }else {
            if (teamA / 60 < 10) {
                AH = "0" + String.valueOf(teamA / 60);
            } else {
                AH = String.valueOf(teamA / 60);
            }
            if (teamA % 60 < 10) {
                AM = "0" + teamA % 60;
            } else {
                AM = String.valueOf(teamA % 60);
            }
        }

        if(teamB == 0 ){
            BH = "00";
            BM ="00";
        }else {
            if (teamB / 60 < 10) {
                BH = "0" + String.valueOf(teamB / 60);
            } else {
                BH = String.valueOf(teamB / 60);
            }

            if (teamB % 60 < 10) {
                BM = "0" + teamB % 0;
            } else {
                BM = String.valueOf(teamB % 60);
            }
        }

        System.out.println(AH +":"+AM);
        System.out.println(BH +":"+BM);
    }

    static class Node{
        int team;
        int time;
        int score;
        Node(int team, int time, int score){
            this.team = team;
            this.time=  time;
            this.score = score;
        }
    }

}
