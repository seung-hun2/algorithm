package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p1015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] A = new int[N];
        int[] P = new int[N];
        Node[] B = new Node[N];
        for(int i=0;i<N;i++){
            B[i] = new Node(sc.nextInt(), i);
        }

        Arrays.sort(B, ((Node o1, Node o2) -> {
            if(o1.num != o2.num) return o1.num-o2.num;
            return o1.idx-o2.idx;
        }));

        for(int i=0;i<N;i++){
            P[B[i].idx] = i;
        }
        for(int i=0;i<N;i++){
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb);

    }

    static class Node{
        public int num,idx;
        Node(int num, int idx){
            this.num = num;
            this.idx = idx;
        }

        public Node() {

        }
    }

}
