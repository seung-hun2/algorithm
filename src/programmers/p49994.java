package programmers;

public class p49994 {

    class Solution {
        public int solution(String dirs) {
            int answer = 0;
            int cur_x = 5, cur_y = 5;
            boolean[][][] map = new boolean[11][11][4];

            for(int i=0;i<dirs.length();i++){
                switch(dirs.charAt(i)){
                    case 'L'-> {
                        if(cur_x > 0) cur_x--;
                        if(!map[cur_y][cur_x][0]) {
                            map[cur_y][cur_x][0] = true;
                            if(cur_x<10){
                                map[cur_y][cur_x+1][2] = true;
                            }
                            answer++;
                        }
                    }
                    case 'U'-> {
                        if(cur_y < 10) {
                            cur_y++;
                            if(!map[cur_y][cur_x][1]) {
                                map[cur_y][cur_x][1] = true;
                                map[cur_y-1][cur_x][3] = true;
                                answer++;
                            }
                        }
                    }
                    case 'R'-> {
                        if(cur_x<10) {
                            cur_x++;
                            if(!map[cur_y][cur_x][2]) {
                                map[cur_y][cur_x][2] = true;

                                map[cur_y][cur_x-1][0] = true;

                                answer++;
                            }
                        }
                    }
                    case 'D'-> {
                        if(cur_y > 0) {
                            cur_y--;
                            if(!map[cur_y][cur_x][3]) {
                                map[cur_y][cur_x][3] = true;

                                map[cur_y+1][cur_x][1] = true;

                                answer++;
                            }
                        }
                    }
                }

            }

            return answer;
        }
    }

}
