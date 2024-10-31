package baekjoon;

import java.util.Scanner;
import java.util.TreeMap;

public class p7662 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<T;tc++){
            int k = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i=0;i<k;i++){
                String str = sc.next();
                int n = sc.nextInt();
                if(str.charAt(0) == 'I'){
                    // 삽입
                    map.put(n, map.getOrDefault(n,0)+1);
                }else if(str.charAt(0) == 'D'){
                    if(map.size() == 0) continue;
                    int num;
                    if(n == 1){
                        num = map.lastKey();
                    }else{
                        num = map.firstKey();
                    }
                    map.put(num, map.get(num)- 1);
                    if(map.get(num) == 0){
                        map.remove(num);
                    }
                }
            }

            if(map.isEmpty()){
                sb.append("EMPTY").append('\n');
            }else{
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
            }

        }

        System.out.println(sb);
    }

}
