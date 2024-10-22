package programmers;

import java.util.Arrays;

public class p340198 {
    class Solution {
        public int solution(int[] mats, String[][] park) {
            int answer = -1;
            Arrays.sort(mats);
            for(int i=0;i<mats.length/2;i++){
                int tmp = mats[i];
                mats[i] = mats[mats.length-1-i];
                mats[mats.length-1-i] = tmp;
            }

            for(int i : mats){
                for(int j=0;j<=park.length-i;j++){
                    for(int k=0;k<=park[0].length-i;k++){
                        boolean check = true;
                        if(park[j][k].equals("-1") && j+i <= park.length && k + i <= park[0].length){
                            for(int l=0;l<i;l++){
                                for(int m=0;m<i;m++){
                                    if(!park[j+l][k+m].equals("-1")){
                                        check = false;
                                        break;
                                    }
                                }
                                if(!check) break;
                            }
                            if(check) return i;
                        }
                    }
                }
            }
            return answer;
        }
    }

}
