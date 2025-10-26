//3.https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //   int[] hash=new int[256];
    //   int max_len=0;
    //   int len=0;
    //   for(int i=0;i<s.length();i++){
    //     Arrays.fill(hash,0);
    //     for(int j=i;j<s.length();j++){
    //         if(hash[s.charAt(j)]==1) break;
    //         len=j-i+1;
    //         max_len=Math.max(len,max_len);
    //         hash[s.charAt(j)]=1;
    //     }
    //   }
    //   return max_len;
    // }

    public int lengthOfLongestSubstring(String s) {
        int max_len=0;
        int l=0;
        int r=0;
        int curr_len=0;
        int[] hash=new int[256];
        Arrays.fill(hash,-1);

        while(r < s.length()){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)]>=l){
                    l=hash[s.charAt(r)]+1;
                }
            }
            curr_len=r-l+1;
            max_len=Math.max(curr_len,max_len);
            hash[s.charAt(r)]=r;
            r++;
        }
        return max_len;
    }
}