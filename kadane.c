#include<stdio.h>
int maxSubArray(int* nums, int numsSize){
    int i,sum=0;
    int maxNum=nums[0];
    for(i=0;i< numsSize;i++){
        if(numsSize==1){
            sum=nums[i];
            maxNum=nums[i];
        }
        else{
            sum=sum+nums[i];
            maxNum= fmax(maxNum,sum);
            if(sum<0){
                sum=0;
            }
        }
    }
    return maxNum;
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
    
    result= maxSubArray(arr,num);  
    printf("\nMaximum sum:%d",result);
    return 0;
}

