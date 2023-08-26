package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p2910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int message = Integer.parseInt(st.nextToken());
            map.put(message, map.getOrDefault(message,0)+1);
        }

        Integer[] frequencies = map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(frequencies, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2)-map.get(o1);
            }
        });

        for(int frequency:frequencies){
            int count = map.get(frequency);
            while (count --> 0) {
                System.out.print(frequency + " ");
            }
        }

    }

}
