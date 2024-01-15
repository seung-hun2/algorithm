package programmers;

public class p81302 {
    static int[] dx = {-1, 1, 0, 0}, dy ={0, 0, -1, 1};
    static char[][] matrix;
    static boolean[][] check;
    static boolean isAvailable;

    static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i=0; i<5; i++) {
            isAvailable = false;
            matrix = new char[5][5];
            for (int j=0; j<5; j++) {
                matrix[j] = places[i][j].toCharArray();
            }

            for (int r=0; r<5; r++) {
                for (int c=0; c<5; c++) {
                    if (matrix[r][c] == 'P') {
                        check = new boolean[5][5];
                        dfs(0, r, c);
                        if (isAvailable) {
                            break;
                        }
                    }
                }
                if (isAvailable) break;
            }
            if (isAvailable) answer[i] = 0;
            else answer[i] = 1;
        }

        return answer;


    }

    static void dfs(int currentDepth, int r, int c) {
        if (currentDepth >= 2) return;
        check[r][c] = true;
        for (int i=0; i<4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || check[nr][nc]) continue;

            if (matrix[nr][nc] == 'O') dfs(currentDepth+1, nr, nc);
            else if (matrix[nr][nc] == 'P') {
                isAvailable = true;
                return;
            }
            else if (matrix[nr][nc] == 'X') {
                continue;
            }

        }
    }

}
