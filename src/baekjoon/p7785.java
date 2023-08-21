package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class p7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            String name = st.nextToken();
            String check = st.nextToken();
            if(check.equals("enter")) set.add(name);
            else set.remove(name);
        }

        String[] ans = set.toArray(new String[set.size()]);

        for(int i=ans.length-1;i>=0;i--){
            System.out.println(ans[i]);
        }

    }

}
