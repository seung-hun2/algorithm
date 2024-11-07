package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p9205 {

    static Node home,rock;
    static Node[] store;
    static boolean[] visited;

    static boolean check = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<t;tc++){
            int n = sc.nextInt();
            home = new Node(sc.nextInt(), sc.nextInt());
            store = new Node[n];

            for(int i=0;i<n;i++){
                store[i] = new Node(sc.nextInt(), sc.nextInt());
            }

            rock = new Node(sc.nextInt(), sc.nextInt());

            if(solve()) sb.append("happy").append('\n');
            else sb.append("sad").append('\n');
        }
        System.out.println(sb);
    }

    static boolean solve(){
        Queue<Node> q = new LinkedList<>();
        q.add(home);
        visited = new boolean[store.length];

        while(!q.isEmpty()){
            Node now = q.poll();
            if(Math.abs(rock.x - now.x) + Math.abs(rock.y - now.y) <= 1000){
                return true;
            }
            for(int i=0;i<store.length;i++) {
                Node next = store[i];
                if(visited[i]) continue;
                if (Math.abs(next.x - now.x) + Math.abs(next.y - now.y) <= 1000 &&
                    Math.abs(next.x - now.x) + Math.abs(next.y - now.y) > 0) {
                    q.add(next);
                    visited[i] = true;
                }
            }

        }
        return false;
    }

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
