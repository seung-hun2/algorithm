package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class p22233 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(sc.next());
        }

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(sc.next(),",");
            while(st.hasMoreTokens()){
                String next = st.nextToken();
                if(set.contains(next)){
                    set.remove(next);
                }
            }
            sb.append(set.size()).append('\n');
        }

        System.out.println(sb);
    }

}
