package baekjoon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class p20291 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] text = new String[N];
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st;
        for(int i=0;i<N;i++){
            text[i] = sc.next();
            st = new StringTokenizer(text[i],".");
            st.nextToken();
            String name = st.nextToken();
            map.put(name, map.getOrDefault(name,0)+1);
        }



        StringBuilder sb = new StringBuilder();

        List<Entry<String, Integer>> a = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        for(Map.Entry<String, Integer> m : a){
            sb.append(m.getKey()).append(' ').append(m.getValue());
            sb.append('\n');
        }

        System.out.println(sb);


    }

}
