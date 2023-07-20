package programmers;

import java.util.Arrays;

public class p42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int idx = 0;
        for (int i = people.length - 1; i >= idx; i--) {
            if (people[i] + people[idx] <= limit) {
                idx++;
                answer++;
            }
            else {
                answer++;
            }
        }
        return answer;
    }

}
