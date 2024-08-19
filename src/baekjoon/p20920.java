package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class p20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            if(str.length() >= M) hashMap.put(str, hashMap.getOrDefault(str,0)+1);
        }
        List<String> words = new ArrayList<>(hashMap.keySet());

        Collections.sort(words, (o1,o2)->{
            if(Integer.compare(hashMap.get(o1), hashMap.get(o2)) != 0){
                return Integer.compare(hashMap.get(o2), hashMap.get(o1));
            }
            if(o1.length() != o2.length()) return o2.length() - o1.length();
            return o1.compareTo(o2);
        });


        StringBuilder sb = new StringBuilder();
        for(String str : words){
            sb.append(str).append('\n');
        }
        System.out.println(sb);
    }

    static class Node{
        String word;
        int cnt;
        Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }

}
