package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class p1764 {

    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        HashSet<String> list = new HashSet<>();
        List<String> answer = new ArrayList<>();

        for(int i=0;i<N;i++){
            list.add(sc.next());
        }
        for(int i=0;i<M;i++){
            String str = sc.next();
            if(list.contains(str)) answer.add(str);
        }
        Collections.sort(answer);

        System.out.println(answer.size());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<answer.size();i++){
            sb.append(answer.get(i)).append('\n');
        }
        System.out.println(sb);

    }
}
