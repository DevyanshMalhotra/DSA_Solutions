#include <stdio.h>
#include <stdlib.h>

int* sortedSquares(int* nums, int numsSize, int* returnSize) {
    int i, j,temp;
    int* result = malloc(numsSize * sizeof(int));
    
    for (i = 0; i < numsSize; i++) {
        result[i] = nums[i] * nums[i];
    }
    
    for (i = 1; i < numsSize; i++) {
        temp=result[i];
		j=i-1;
		while(j>=0 && result[j]>temp){
			result[j+1]=result[j];
			j=j-1;
		}
        result[j+1]=temp;
    }
    
    *returnSize = numsSize;
    return result;
}

int main() {
    int arr[100], i, num, j;
    int ret_s;  
    
    printf("Size of array:\n");
    scanf("%d", &num);
    
    for (j = 0; j < num; j++) {
        printf("Element %d value:", j + 1);
        scanf("%d", &arr[j]);
    }
    
    int* ptr = sortedSquares(arr, num, &ret_s);  
    
    printf("[");
    for (i = 0; i < num; i++) {
        printf(" %d ", *(ptr + i));
    }
    printf("]");
    
    free(ptr);
    
    return 0;
}

