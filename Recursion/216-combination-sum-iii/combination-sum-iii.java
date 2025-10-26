class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),1,k,n,0);
        return result;       
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current,int start, int k,int n,int sum){
        if(sum==n && current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        if(sum>n) return;
        for(int i=start;i<10;i++){
            current.add(i);
            backtrack(result,current,i+1,k,n,sum+i);
            current.remove(current.size()-1);
        }
    }
}

