#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "asm.h"

int main(void) {
    int vec[]={1,0,0};
	int num=sizeof(vec)/sizeof(int);

    printf("\n");

    sort_array(vec, num);

    printf("Sorted array in ascending order:\n");
    for (int i = 0; i < num; i++) {
        printf("%d ", vec[i]);
    }
    printf("\n");

    return 0;
}
