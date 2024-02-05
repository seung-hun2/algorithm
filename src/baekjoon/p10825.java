package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p10825 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Node> node = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            node.add(new Node(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(node, (Node o1, Node o2) -> {
            if (o1.k == o2.k) {
                if(o1.e == o2.e){
                    if(o1.m == o2.m){
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.m-o1.m;
                }
                return o1.e - o2.e;
            }
            return o2.k - o1.k;
        });
        StringBuilder sb = new StringBuilder();
        for (Node node1 : node) {
            sb.append(node1.name).append('\n');
        }
        System.out.println(sb);
    }

    static class Node {

        String name;
        int k;
        int e;
        int m;

        public Node(String name, int k, int e, int m) {
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }
    }

}
