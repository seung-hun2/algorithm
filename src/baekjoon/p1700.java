package baekjoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class p1700 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<K;i++){
            list.add(sc.nextInt());
        }

        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for(int i=0;i<K;i++){
            int num = list.get(i);
            if(set.contains(num)) continue;
            if(set.size()<N && set.add(num)) continue;

            int max = -1, idx= -1;
            for(int s: set){
                int tmp = 0;
                List<Integer> sub = list.subList(i+1,K);
                if(sub.contains(s)){
                    tmp = sub.indexOf(s)+1;
                }else{
                    tmp = K-i-1;
                }

                if(tmp > max){
                    max = tmp;
                    idx = s;
                }
            }
            set.remove(idx);
            set.add(num);
            cnt++;
        }
        System.out.println(cnt);
    }

}
