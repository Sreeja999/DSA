//287.https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int[] hash=new int[n];
        Arrays.fill(hash,-1);
        for(int i=0;i<n;i++){
            if(hash[nums[i]]==1){
                return nums[i];
            }else{
                hash[nums[i]]=1;
            }
        }
        return -1;
    }
}