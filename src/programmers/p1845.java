package programmers;

import java.util.HashSet;

public class p1845 {
    class Solution {
        public int solution(int[] nums) {
            int max = nums.length/2;
            HashSet<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num);
            }
            if(set.size()>max){
                return max;
            }else{
                return set.size();
            }
        }
    }

}
