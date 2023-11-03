package baekjoon;

import java.util.Scanner;

public class p17136 {

    static int ans = 26;
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int[][] board = new int[11][11];
    static int nextRow;
    static int nextCol;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        solve(0, 0, 0);
        if (ans == 26) {
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }

    }

    static void fill(int row, int col, int size, int color) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[row + i][col + j] = color;
            }
        }
    }

    static boolean isValid(int row, int col, int size) {
        if (row + size > 10 || col + size > 10) {
            return false;
        }
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[row + r][col + c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void findNext(int row, int col){
        for(int r=row;r<10;r++){
            for(int c=0;c<10;c++){
                if(board[r][c] == 1){
                    nextRow = r;
                    nextCol = c;
                    return;
                }
            }
        }
        nextRow = -1;
        nextCol = -1;
    }

    public static void solve(int row, int col, int cnt) {
        // base case
        if (ans <= cnt) {
            return;
        }
        findNext(row, col);
        if (nextRow == -1 && nextCol == -1) {
            ans = cnt;
            return;
        }

        // recursive case
        int r = nextRow;
        int c = nextCol;

        for(int i=1;i<=5;i++){
            if(paper[i] == 0) continue;
            if(!isValid(r,c,i)) continue;
            paper[i]--;
            fill(r,c,i,0);
            solve(r,c,cnt+1);
            fill(r,c,i,1);
            paper[i]++;
        }
    }

}
