package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p16198 {

    static int N,max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(sc.nextInt());
        }

        recur(list, 0);
        System.out.println(max);

    }

    static void recur(List<Integer> list, int sum){
        if(list.size()==2){
            max = Math.max(max, sum);
        }else {
            for(int i=1;i<list.size()-1;i++){
                int tmp = list.get(i);
                int charge = list.get(i-1) * list.get(i+1);
                list.remove(i);
                recur(list,sum+charge);
                list.add(i,tmp);
            }
        }
    }

}
