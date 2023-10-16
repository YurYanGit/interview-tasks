package tasks.top_interview150.array_string;

/*
88. Merge Sorted Array
        Easy
        Topics
        Companies
        Hint

        You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
        representing the number of elements in nums1 and nums2 respectively.

        Merge nums1 and nums2 into a single array sorted in non-decreasing order.

        The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
        To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
        and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



        Example 1:

        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

        Example 2:

        Input: nums1 = [1], m = 1, nums2 = [], n = 0
        Output: [1]
        Explanation: The arrays we are merging are [1] and [].
        The result of the merge is [1].

        Example 3:

        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        Output: [1]
        Explanation: The arrays we are merging are [] and [1].
        The result of the merge is [1].
        Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.



        Constraints:

        nums1.length == m + n
        nums2.length == n
        0 <= m, n <= 200
        1 <= m + n <= 200
        -1^9 <= nums1[i], nums2[j] <= 1^9
*/

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int m1 = 3;
        int[] nums2 = {2,5,6};
        int n1 = 3;
//    Output: [1,2,2,3,5,6]
//    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

        int[] nums12 = {1};
        int m2 = 1;
        int[] nums22 = {};
        int n2 = 0;
//    Output: [1]
//    Explanation: The arrays we are merging are [1] and [].
//    The result of the merge is [1].

        int[] nums13 = {0};
        int m3 = 0;
        int[] nums23 = {1};
        int n3 = 1;

//    Output: [1]
//    Explanation: The arrays we are merging are [] and [1].
//    The result of the merge is [1].

//    Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

        merge(nums1, m1, nums2, n1);
        System.out.println(Arrays.toString(nums1));

        merge(nums12, m2, nums22, n2);
        System.out.println(Arrays.toString(nums12));

        merge(nums13, m3, nums23, n3);
        System.out.println(Arrays.toString(nums13));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1; // Index for the last element in nums1
        int j = n - 1; // Index for the last element in nums2
        int k = m + n - 1; // Index for the last element in the merged array

        while (i >= 0 && j >= 0) {
            // Compare the elements from the end of both arrays
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
