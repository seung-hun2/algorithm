package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p9019 {

    static int A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            A = sc.nextInt();
            B = sc.nextInt();
            boolean[] check = new boolean[10000];
            char[] cmd = {'D','S','L','R'};

            Queue<Node> q = new LinkedList<>();
            q.add(new Node(A, new StringBuilder()));
            check[A] = true;
            while(!q.isEmpty()){
                Node node = q.poll();
                if(node.num == B){
                    System.out.println(node.cmd);
                    break;
                }

                int[] next = {node.calcD(), node.calcS(), node.calcL(), node.calcR()};
                for(int i=0;i<4;i++){
                    if(!check[next[i]]){
                        check[next[i]] = true;
                        q.add(new Node(next[i], new StringBuilder(node.cmd).append(cmd[i])));
                    }
                }
            }
        }
    }

    public static class Node {

        int num;
        StringBuilder cmd;

        public Node(int num, StringBuilder cmd) {
            this.num = num;
            this.cmd = cmd;
        }

        public int calcD() {
            return num * 2 % 10000;
        }

        public int calcS() {
            return num - 1 < 0 ? 9999 : num - 1;
        }

        public int calcL(){
            return (num%1000)*10 + num/1000;
        }

        public int calcR(){
            return num%10 * 1000 + num/10;
        }
    }
}
