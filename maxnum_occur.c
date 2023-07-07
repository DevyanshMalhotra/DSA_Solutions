#include<stdio.h>
int majorityElement(int* nums, int numsSize) {
    int candidate = nums[0];
    int i, count = 1;
    
    for (i = 1; i < numsSize; i++) {
        if (candidate == nums[i]) {
            count++;
        } else {
            count--;
        }
        
        if (count == 0) {
            candidate = nums[i];
            count = 1;
        }
    }
    
    return candidate;
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
    
    result= majorityElement(arr,num);  
    printf("\nMaximum no:%d",result);
    return 0;
}
