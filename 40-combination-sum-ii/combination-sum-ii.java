class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result,candidates,target,0,new ArrayList<>(),0);
        return result;        
    }

    private void backtrack(List<List<Integer>> result,int[] candidates, int target, int start,List<Integer> current,int sum){
        if(sum==target){
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if(sum>target) return;
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            current.add(candidates[i]);
            backtrack(result,candidates,target,i+1,current,sum+candidates[i]);
            current.remove(current.size()-1);
        }
    }
}

