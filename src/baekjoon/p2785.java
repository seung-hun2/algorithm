package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p2785 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(sc.nextInt());

        Collections.sort(list);

        int ans = 0;
        while(true){
            if(list.size()<=1) break;
            list.set(0,list.get(0)-1);
            list.remove(list.size()-1);
            if(list.get(0) == 0) list.remove(0);
            ans++;
        }
        System.out.println(ans);
    }

}
