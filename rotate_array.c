#include <stdio.h>

void rotate(int* nums, int numsSize, int k) {
	int i;
    k = k % numsSize;
    int* temp = malloc(numsSize * sizeof(int));
    for (i = 0; i < numsSize; i++) {
        temp[(i + k) % numsSize] = nums[i];
    }
    for (i = 0; i < numsSize; i++) {
        nums[i] = temp[i];
    }
    printf("[");
    for (i = 0; i < numsSize; i++) {
        printf(" %d ", nums[i]);
    }
    printf("]");
    free(temp);
}
int main() {
    int a[100], n, t,j;
    printf("Size of array:\n");
    scanf("%d", &n);
    printf("No. of times array has to be rotated:\n");
    scanf("%d", &t); 
     for (j= 0; j < n; j++) {
        printf("Element %d value:", j + 1);
        scanf("%d", &a[j]);
    }
    rotate(a, n, t);
    return 0;
}

