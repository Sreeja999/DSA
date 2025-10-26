//22. https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack(n,0,0,result,"");
        return result;
    }
    private void backtrack(int n,int open_count,int close_count,List<String> result,String s){
        if(open_count+close_count== (2*n)){
            result.add(s);
            return;
        }
        if(open_count<n){
            backtrack(n,open_count+1,close_count,result,s+"(");
        }
        if(close_count<open_count){
            backtrack(n,open_count,close_count+1,result,s+")");
        }
    }
}