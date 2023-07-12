#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int* majorityElement(int* nums, int numsSize, int* returnSize);

int main() {
    int nums[] = {1, 1, 1, 2, 2, 3, 3};
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    int i,returnSize = 0;
    int* result = majorityElement(nums, numsSize, &returnSize);

    printf("Majority Elements: ");
    for (i = 0; i < returnSize; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");

    free(result);
    return 0;
}

int* majorityElement(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)malloc(numsSize * sizeof(int));
    int el1 = INT_MIN, el2 = INT_MIN, i, k = 0, check = 0;
    int count1 = 0, count2 = 0;
    int counts1, counts2;

    for (i = 0; i < numsSize; i++) {
        if (count1 == 0 && nums[i] != el2) {
            el1 = nums[i];
            count1++;
        } else if (count2 == 0 && nums[i] != el1) {
            el2 = nums[i];
            count2++;
        } else if (nums[i] == el1) {
            count1++;
        } else if (nums[i] == el2) {
            count2++;
        } else {
            count1--;
            count2--;
        }
    }
    counts1 = 0;
    counts2 = 0;
    for (i = 0; i < numsSize; i++) {
        if (el1 == nums[i]) {
            counts1++;
        } else if (el2 == nums[i]) {
            counts2++;
        }
    }
    if (counts1 > (numsSize / 3) && counts2 > (numsSize / 3)) {
        check++;
        result[k] = el1;
        k++;
        check++;
        result[k] = el2;
        k++;
    } else if (counts1 > (numsSize / 3)) {
        check++;
        result[k] = el1;
        k++;
    } else if (counts2 > (numsSize / 3)) {
        check++;
        result[k] = el2;
        k++;
    }

    *returnSize = check;
    return result;
}

