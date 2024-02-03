int maxChunksToSorted(int* arr, int arrSize) {
    int i,max_chunks = 0;
    int current_max = 0;
    
    for (i = 0; i < arrSize; i++) {
        current_max = (arr[i] > current_max) ? arr[i] : current_max;
        if (i == current_max) {
            max_chunks++;
        }
    }
    
    return max_chunks;
}
#include <stdio.h>

int main() {
    int arr[] = {1, 4, 3, 0, 2, 5};
    int arrSize = sizeof(arr) / sizeof(arr[0]);
    
    int result = maxChunksToSorted(arr, arrSize);
    printf("Largest number of chunks: %d\n", result); 
    
    return 0;
}

