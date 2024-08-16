package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1205 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int point = sc.nextInt();
        int P = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            list.add(sc.nextInt());
        }

        if(N == P && point <= list.get(list.size()-1)){
            System.out.println(-1);
        }else{
            int rank = 1;
            for(int i=0;i<list.size();i++){
                if(point < list.get(i)) rank++;
                else break;
            }
            System.out.println(rank);
        }

    }

}
