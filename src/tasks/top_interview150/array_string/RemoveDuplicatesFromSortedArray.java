package tasks.top_interview150.array_string;

/*
26. Remove Duplicates from Sorted Array
Easy
Topics
Companies
Hint

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    Return k.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}

If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

 */

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 2};
        int[] nums11 = {1, 2, 2};
        int[] nums12 = {2, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums3 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5};

//
//        System.out.println(removeDuplicates(nums1));
//        System.out.println(removeDuplicates(nums11));
//        System.out.println(removeDuplicates(nums12));
//        System.out.println(removeDuplicates(nums2));
//        System.out.println(removeDuplicates(nums3));

        System.out.println(removeDuplicates2(nums1));
        System.out.println(removeDuplicates2(nums11));
        System.out.println(removeDuplicates2(nums12));
        System.out.println(removeDuplicates2(nums2));
        System.out.println(removeDuplicates2(nums3));
    }

    public static int removeDuplicates(int[] nums) {

        int k = 0;

        for (int i = 0; i < nums.length - 1; i++) {
                while (nums[i] == nums[i + 1] && nums[i] != -1) {
                    if (nums.length == 1) {
                        k = 1;
                    } else if (nums.length == 2) {
                        nums[1] = -1;
                        k = 1;
                    } else {
                        for (int j = nums.length - 1 ; j > i + 1; j--) {
                            nums[j - 1] = nums[j];
                        }
                        nums[nums.length - i - 1] = -1;
                        k++;
                    }
                }
        }

        System.out.println(Arrays.toString(nums));

        return nums.length - k;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int uniqueCount = 1; // Initialize with the first element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueCount] = nums[i]; // Move the unique element to the next position
                uniqueCount++;
            }
        }

        System.out.println(Arrays.toString(nums));

        return uniqueCount;
    }
}

