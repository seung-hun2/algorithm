package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p12018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int P = sc.nextInt();
            int L = sc.nextInt();
            boolean check = true;
            if(L > P ){
                check = false;
                if(m > 0) {
                    ans++;
                    m--;
                }
            }
            List<Integer> nextList = new ArrayList<>();
            for(int j=0;j<P;j++){
                int next = sc.nextInt();
                nextList.add(next);
            }
            if(check){
                Collections.sort(nextList);
                list.add(nextList.get(P-L));
            }
        }

        Collections.sort(list);
        for(int i : list){
            if(i > m) break;
            m -= i;
            ans++;
        }

        System.out.println(ans);

    }

}
