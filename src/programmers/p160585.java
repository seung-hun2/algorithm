package programmers;

public class p160585 {
    char[][] map;

    public int win(char c ){
        int game = 0;
        for(int i = 0; i < 3; i++)
        {
            if(map[i][0] == c && map[i][0] == map[i][1] && map[i][1] == map[i][2])
                game++;
            if(map[0][i] == c && map[0][i] == map[1][i] && map[1][i] == map[2][i])
                game++;
        }
        if(map[0][0] == c && map[0][0] == map[1][1] && map[1][1] == map[2][2])
            game++;
        if(map[0][2] == c && map[0][2] == map[1][1] && map[1][1] == map[2][0])
            game++;
        return game;
    }
    public int solution(String[] board) {
        int answer = 1;
        int oCnt = 0;
        int xCnt = 0;
        int bingo = 0;
        map = new char[3][3];
        boolean fin = false;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                map[i][j] = board[i].charAt(j);
                if(board[i].charAt(j) == 'X'){
                    xCnt++;
                }else if(board[i].charAt(j) == 'O'){
                    oCnt++;
                }
            }
        }

        if(win('O') > 0 && win('X') > 0) return 0;
        if(win('O') > 0) {
            if(oCnt == xCnt)
                return 0;
        }
        if(win('X') > 0) {
            if(oCnt > xCnt)
                return 0;
        }
        if(xCnt > oCnt || oCnt - xCnt > 1) return 0;

        return answer;
    }

}
