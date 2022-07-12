package twoSum;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.
*/

public class SumElementFinder {
    public int[] twoSum(int[] nums, int target) {
        for(var i=0; i<nums.length-1; i++) {
            for(var j=i+1; j<nums.length; j++) {
                if(i!=j && nums[i]+nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
