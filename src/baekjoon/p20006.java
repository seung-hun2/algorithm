package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p20006 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int m = sc.nextInt();
        Player[] players = new Player[p];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<p;i++){
            players[i] = new Player(sc.nextInt(), sc.next());
        }

        for(int i=0;i<p;i++){
            List<Player> room = new ArrayList<>();
            if(!players[i].check){
                for(int j=i;j<p;j++){
                    if(room.size() == m) break;
                    int level = players[j].level;
                    String name = players[j].name;
                    if(!players[j].check && players[i].level-10 <= level && players[i].level + 10 >= level){
                        players[j].check = true;
                        room.add(new Player(level,name));
                    }
                }

                Collections.sort(room, (o1, o2) -> o1.name.compareTo(o2.name));
                if(room.size() == m ){
                    sb.append("Started!").append('\n');
                }else{
                    sb.append("Waiting!").append('\n');
                }
                for(Player player : room){
                    sb.append(player.level).append(" ").append(player.name).append('\n');
                }
            }
        }

        System.out.println(sb);

    }

    static class Player{
        int level;
        String name;
        boolean check;

        public Player(int level, String name){
            this.level = level;
            this.name = name;
        }

    }

}
