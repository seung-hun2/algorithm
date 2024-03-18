package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class p42890 {
    static int answer,n,m;
    static List<HashSet<Integer>> candidateKey;
    static String[][] relationCopy;
    public int solution(String[][] relation) {
        relationCopy = relation;
        answer = 0;

        candidateKey = new ArrayList<>();
        n = relationCopy.length;
        m = relationCopy[0].length;

        for(int i=1;i<m+1;i++){
            combination(0,i,0,new HashSet<>());
        }

        return answer;

    }

    static void combination(int idx, int size, int depth, HashSet<Integer> set){
        if(depth == size){
            if(!unique(set)) return;
            for(HashSet<Integer> key : candidateKey){
                if(set.containsAll(key)) return;
            }

            candidateKey.add(set);
            answer++;
            return;
        }

        for(int i=idx;i<m;i++){
            HashSet<Integer> newSet = new HashSet<>(set);
            newSet.add(i);
            idx++;
            combination(idx, size, depth+1, newSet);
        }
    }

    static boolean unique(HashSet<Integer> set){
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int idx : set){
                sb.append(relationCopy[i][idx]);
            }
            if(!list.contains(sb.toString())){
                list.add(sb.toString());
            }else{
                return false;
            }
        }
        return true;
    }

}
