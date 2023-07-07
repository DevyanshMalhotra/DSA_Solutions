#include<stdio.h>
int maxProduct(int* nums, int numsSize) {
    int i, maxProduct = 1, minProduct = 1, maxResult = nums[i];
    
    for (i = 0; i < numsSize; i++) {
        if (nums[i] < 0) {
            int temp = maxProduct;
            maxProduct = minProduct;
            minProduct = temp;
        }
        maxProduct = fmax(nums[i], maxProduct * nums[i]);
        minProduct = fmin(nums[i], minProduct * nums[i]);
        maxResult = fmax(maxResult, maxProduct);
    }
    
    return maxResult;
}
int main() {
    int arr[100], num, j;
    int result;  
    
    printf("Size of array:\n");
    scanf("%d", &num);
    
    for (j = 0; j < num; j++) {
        printf("Element %d value:", j + 1);
        scanf("%d", &arr[j]);
    }
    
    result= maxProduct(arr,num);  
    printf("\nMaximum product:%d",result);
    return 0;
}

