package binarysearch;

import java.util.Arrays;
import java.util.List;

public class CountOfSmallerAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        int[] indices = new int[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
            result[i] = 0;
        }
        mergeSort(nums, indices, result, 0, n - 1);
        return Arrays.asList(result);
    }

    private void mergeSort(int[] nums, int[] indices, Integer[] result, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, result, left, mid);
        mergeSort(nums, indices, result, mid + 1, right);
        merge(nums, indices, result, left, mid, right);
    }

    private void merge(int[] nums, int[] indices, Integer[] result, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                temp[k] = indices[j];
                j++;
            } else {
                result[indices[i]] += right - j + 1;
                temp[k] = indices[i];
                i++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = indices[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = indices[j];
            j++;
            k++;
        }

        for (i = left; i <= right; i++) {
            indices[i] = temp[i - left];
        }
    }
}
