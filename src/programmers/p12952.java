package programmers;

public class p12952 {
    int max=0;
    int count=0;
    int[] arr;
    public int solution(int n) {
        arr = new int[n];
        max = n;
        dfs(0);

        return count;
    }

    public void dfs(int depth){
        if(depth == max){
            count++;
            return;
        }

        for(int i=0;i<max;i++){
            arr[depth] = i;
            if(possible(depth)){
                dfs(depth+1);
            }
        }
    }

    public boolean possible(int col){
        for(int i=0;i<col;i++){
            if(arr[col] == arr[i]) return false;

            if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) return false;

        }
        return true;
    }

}
