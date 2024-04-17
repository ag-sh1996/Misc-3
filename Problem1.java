class Solution {
    //TC: O(nlogk)  k --range of capacity
    //SC: O(1)
    public int shipWithinDays(int[] weights, int days) {
        int low  =  0, high =0;
        for(int wt : weights){
            low = Math.max(low,wt);
            high += wt;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            int currDays = 1;
            int currWt = weights[0];
            for(int i = 1; i < weights.length; i++){
                
                if(currWt + weights[i]> mid){
                    currDays++;
                    currWt = 0;
                }
                currWt += weights[i];
            }
            if(currDays == days){
                //keep moving left
                high = mid - 1;
            }else if(currDays < days){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
