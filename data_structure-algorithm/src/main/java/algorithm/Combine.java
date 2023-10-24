package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/10/24
 * @Version V1.0
 **/
public class Combine {

    List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k,1);
        return res;
    }

    public void backtracking(int n, int k,int startIndex){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex;i<=n;i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.pop();
        }
    }
}
