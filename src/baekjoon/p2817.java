package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class p2817 {

    static class Score {

        public Score(int staffIndex, double score) {
            this.staffIndex = staffIndex;
            this.score = score;
        }

        int staffIndex;
        double score;
    }

    public static void sortScores(Score[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i].score > arr[j].score){
                    Score cur = arr[i];
                    for(int k=i;k>j;k--){
                        arr[k] = arr[k-1];
                    }
                    arr[j] = cur;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        double vaildCut = X * 0.05;
        boolean[] validCandidate = new boolean[26];
        int[] staffVote = new int[26];
        int candidateCount = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int vote = Integer.parseInt(st.nextToken());
            if (vote >= vaildCut) {
                int index = name.charAt(0) - 'A';
                validCandidate[index] = true;
                staffVote[index] = vote;
                candidateCount++;
            }

        }

        Score[] scores = new Score[candidateCount * 14];
        int scoreIndex = 0;
        for(int i=0;i<26;i++){
            if(validCandidate[i]){
                for(int j=1;j<=14;j++){
                    scores[scoreIndex++] = new Score(i, (double) staffVote[i]/j);
                }
            }
        }

        sortScores(scores);

        int[] ans = new int[26];
        for(int i=0;i<14;i++){
            ans[scores[i].staffIndex]++;
        }

        for(int i=0;i<26;i++){
            if(validCandidate[i]){
                System.out.println((char) (i+'A') + " "+ans[i]);
            }
        }


    }

}
