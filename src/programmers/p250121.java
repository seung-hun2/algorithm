package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p250121 {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        String[] check = {"code","date","maximum","remain"};
        int idx = 0;
        int s_idx = 0;
        for(int i=0;i<4;i++){
            if(check[i].equals(ext)) idx = i;
            if(check[i].equals(sort_by)) s_idx = i;
        }
        final int sort_idx = s_idx;
        for(int i=0;i<data.length;i++){
            if(data[i][idx] < val_ext) list.add(data[i]);
        }
        Collections.sort(list, (o1,o2)->{
            return o1[sort_idx]-o2[sort_idx];
        });

        return list;
    }

}
