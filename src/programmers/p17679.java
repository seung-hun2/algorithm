package programmers;

public class p17679 {
    class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] map = new char[m][n];
            for(int i=0;i<m;i++){
                map[i] = board[i].toCharArray();
            }
            while(true){
                int cnt = checkBlock(m,n,map);
                if(cnt == 0) break;
                answer += cnt;

                dropBlock(m,n,map);
            }

            return answer;
        }
        public void dropBlock(int m, int n, char[][] map){
            for(int i=0;i<n;++i){
                for(int j=m-1;j>=0;j--){
                    if(map[j][i] == '.'){
                        for(int k=j-1;k>=0;--k){
                            if(map[k][i] != '.'){
                                map[j][i] = map[k][i];
                                map[k][i] = '.';
                                break;
                            }
                        }
                    }
                }
            }
        }
        public int checkBlock(int m,int n,char[][] map){
            int cnt=0;
            boolean[][] check = new boolean[m][n];

            for(int i=0;i<m-1;++i){
                for(int j=0;j<n-1;++j){
                    if(map[i][j] == '.') continue;
                    checkFour(map,check,i,j);
                }
            }
            for(int i=0;i<m;++i){
                for(int j=0;j<n;j++){
                    if(check[i][j]){
                        cnt++;
                        map[i][j] = '.';
                    }
                }
            }
            return cnt;
        }

        public void checkFour(char[][] map, boolean[][] check, int i, int j){
            char block = map[i][j];
            for(int r=i;r<i+2;++r){
                for(int c=j;c<j+2;++c){
                    if(map[r][c] != block) return;
                }
            }
            for(int r=i;r<i+2;++r){
                for(int c=j;c<j+2;++c){
                    check[r][c] = true;
                }
            }
        }

    }

}
