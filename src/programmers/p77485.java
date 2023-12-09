package programmers;

public class p77485 {

    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows][columns];
        int index = 1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j] = index++;
            }
        }
        for(int i=0;i<queries.length;i++){
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }

    public int rotate(int[] q){
        int top = q[0]-1;
        int right = q[3]-1;
        int left = q[1]-1;
        int bottom = q[2]-1;
        int min = Integer.MAX_VALUE;

        int start = arr[top][left];
        for(int i=top;i<bottom;i++){
            min = Math.min(arr[i][left],min);
            arr[i][left] = arr[i+1][left];
        }
        for(int i=left;i<right;i++){
            min = Math.min(arr[bottom][i],min);
            arr[bottom][i] = arr[bottom][i+1];
        }
        for(int i=bottom;i>top;i--){
            min = Math.min(arr[i][right],min);
            arr[i][right] = arr[i-1][right];
        }
        for(int i=right;i>left;i--){
            min = Math.min(arr[top][i],min);
            arr[top][i] = arr[top][i-1];
        }
        arr[top][left+1] = start;

        return min;
    }

}
