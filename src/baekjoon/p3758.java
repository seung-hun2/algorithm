package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3758 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int T = 0; T < testCase; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] list = new Team[n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamID = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (list[teamID - 1] == null) {
                    list[teamID - 1] = new Team();
                    list[teamID - 1].id = teamID;
                    list[teamID - 1].scoreList = new int[k + 1];
                }

                list[teamID - 1].scoreList[problemNum] = Math.max(score, list[teamID - 1].scoreList[problemNum]);
                list[teamID - 1].submitNum++;
                list[teamID - 1].lastSubmit = i;

            }
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += list[i].scoreList[j];
                }
                list[i].totalScore = sum;
            }

            Arrays.sort(list, (o1,o2)->{
                if(o1.totalScore == o2.totalScore){
                    if(o1.submitNum == o2.submitNum){
                        return o1.lastSubmit - o2.lastSubmit;
                    }
                    return o1.submitNum - o2.submitNum;
                }
                return o2.totalScore - o1.totalScore;
            });

            for (int i = 0; i < n; i++) {
                if (list[i].id == t) {
                    sb.append(i + 1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }


    static class Team {

        int id;
        int[] scoreList;
        int submitNum;
        int lastSubmit;
        int totalScore;

    }
}