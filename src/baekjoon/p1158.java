package baekjoon;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        List<Integer> survivors = new ArrayList<>();
        for(int i=1;i<=N;i++) survivors.add(i);

        sb.append('<');
        int[] ans = new int[N];
        int currentIndex = 0;
        for(int i=0;i<N;i++){
            currentIndex = (currentIndex + K - 1)% survivors.size();
            sb.append(survivors.remove(currentIndex));
            if(i!=N-1) sb.append(", ");
        }
        sb.append('>');
        System.out.println(sb);
    }

}
