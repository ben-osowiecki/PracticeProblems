package twoSum;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.
*/

import java.util.HashMap;

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

    public int[] twoSumImproved(int[] nums, int target) {
        HashMap<Integer, Integer> previousEntries = new HashMap<>();

        for(var i=0; i< nums.length; i++) {
            Integer difference = target-nums[i];
            if(previousEntries.containsKey(difference)) {
                return new int[]{previousEntries.get(difference), i};
            }
            previousEntries.put(nums[i], i);
        }

        return new int[]{};
    }
}
