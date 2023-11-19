package baekjoon;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1941 {

    static int[] stu = new int[25];
    static boolean[] check = new boolean[25];
    static List<Integer> pick = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        for(int i=0;i<5;i++){
            String str = sc.next();
            for(int j=0;j<5;j++){
                if(str.charAt(j) == 'S'){
                    stu[cnt] = 1;
                }else{
                    stu[cnt] = 0;
                }
                cnt++;
            }
        }
        int princess = nextCombination(0);
        System.out.println(princess);
    }

    static int nextCombination(int num){
        // base case
        if(pick.size()==7){
            // 이다솜파의 인원이 4명 이상인지
            int cnt = 0;
            for(int i=0;i<7;i++){
                if(stu[pick.get(i)]==1) cnt++;
            }
            if(cnt < 4) return 0;
            for(int i=0;i<7;i++){
                check[i] = false;
            }
            if(dfs(0) == 7) return 1;
            return 0;
        }
        if(num >= 25) return 0;

        // recursive case
        int ret = 0;
        ret += nextCombination(num+1);
        pick.add(num);
        ret += nextCombination(num+1);
        pick.remove(pick.size()-1);
        return ret;
    }
    static int dfs(int num){
        int count = 1;
        check[num] = true;
        int me = pick.get(num);
        for(int i=1;i<7;i++){
            int you = pick.get(i);
            if(!check[i]&&isFriend(me,you)){
                count += dfs(i);
            }
        }
        return count;
    }

    static boolean isFriend(int a, int b){
        int diff = Math.abs(a-b);
        int max = Math.max(a,b);
        if(diff == 1 && max % 5 != 0) return true;
        if(diff == 5) return true;
        return false;
    }

}
