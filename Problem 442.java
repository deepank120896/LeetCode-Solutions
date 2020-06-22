// Find All Duplicates in an Array
// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
// Find all the elements that appear twice in this array.

// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [2,3]


// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0)
                result.add(Math.abs(nums[i]));
            nums[index] = -nums[index];
        }
        return result;
    }
}