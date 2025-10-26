class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        backtrack(result,current,0,target,candidates,0);
        return result;
    }

    private void backtrack(List<List<Integer>> result,List<Integer> current,int start, int target, int[] candidates,int sum) {
        if(sum==target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(sum>target) return;
        for(int i=start;i<candidates.length;i++){
            current.add(candidates[i]);
            backtrack(result,current,i,target,candidates,sum+candidates[i]);
            current.remove(current.size()-1);
        }
    }
}



