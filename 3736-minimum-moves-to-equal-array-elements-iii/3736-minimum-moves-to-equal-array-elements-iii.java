class Solution {
    public int minMoves(int[] nums) {
        int maxi =nums[0] , total = 0;
        for(int num:nums)maxi=Math.max(maxi,num);
        for(int num:nums)total+= maxi-num;
        return total;
    }
}