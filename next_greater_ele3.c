#include <stdio.h>
#include <string.h>

void swap(char *a, char *b) {
    char temp = *a;
    *a = *b;
    *b = temp;
}

void reverse(char *str, int start, int end) {
    while (start < end) {
        swap(&str[start], &str[end]);
        start++;
        end--;
    }
}

int nextGreaterElement(int n) {
    char numString[20]; 
    sprintf(numString, "%d", n);

    int length = strlen(numString);

    int i, j;
    for (i = length - 2; i >= 0; i--) {
        if (numString[i] < numString[i + 1]) {
            break;
        }
    }

    if (i == -1) {
        return -1; 
    }

    for (j = length - 1; j > i; j--) {
        if (numString[j] > numString[i]) {
            swap(&numString[i], &numString[j]);
            break;
        }
    }

    reverse(numString, i + 1, length - 1);

    int result = atoi(numString);
    if(result>n){
        return result;
    }
    else{
        return -1;
    }
    
}
int main() {
    int number;
    printf("Enter a number: ");
    scanf("%d", &number);

    int result = nextGreaterElement(number);
    printf("Next greater element: %d\n", result);

    return 0;
}
