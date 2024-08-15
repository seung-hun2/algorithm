package baekjoon;

import java.util.Scanner;

public class p8979 {

    static int N,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        Node[] node = new Node[N];
        for(int i=0;i<N;i++){
            node[i] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        int res = countRank(node);
        System.out.println(res);
    }

    static class Node{
        int name,g,s,d;
        Node(int name, int g, int s, int d){
            this.name = name;
            this.g = g;
            this.s = s;
            this.d = d;
        }
    }

    static int countRank(Node[] node){
        int rank = 1;
        int ans = 0;
        for(int i=0;i<N;i++){
            if(node[i].name == K){
                ans = i;
            }
        }

        for(int i=0;i<N;i++){
            if(node[i].g > node[ans].g) rank++;
            else if(node[i].g == node[ans].g && node[i].s > node[ans].s) rank++;
            else if(node[i].g == node[ans].g && node[i].s == node[ans].s && node[i].d > node[ans].d) rank++;
        }
        return rank;
    }

}
