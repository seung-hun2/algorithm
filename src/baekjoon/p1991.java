package baekjoon;

import java.util.Scanner;

public class p1991 {

    static int[][] childs;
    static StringBuilder sb = new StringBuilder();;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        childs = new int[30][2];
        for(int i=0;i<N;i++){
            char ch = sc.next().charAt(0);
            int cur = (int)(ch-'A');
            for(int j=0;j<2;j++){
                char c = sc.next().charAt(0);
                if(c!='.') childs[cur][j] = (int)(c-'A');
                else childs[cur][j] = -1;
            }
        }

        pre_order(0);
        sb.append('\n');
        in_order(0);
        sb.append('\n');
        post_order(0);

        System.out.println(sb);

    }

    static void in_order(int x){
        if(x == -1) return;
        in_order(childs[x][0]);
        sb.append((char)(x+'A'));
        in_order(childs[x][1]);
    }

    static void pre_order(int x){
        if(x == -1) return;
        sb.append((char)(x+'A'));
        pre_order(childs[x][0]);
        pre_order(childs[x][1]);
    }

    static void post_order(int x) {
        if (x == -1) return;
        post_order(childs[x][0]);
        post_order(childs[x][1]);
        sb.append((char)(x + 'A'));
    }


}
