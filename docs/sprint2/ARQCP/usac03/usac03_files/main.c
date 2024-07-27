#include <stdio.h>
#include "asm.h"

int main(void){
	int array[]={0,0,0};
    int length = 3;
    int read = 0;
    int write = 0;
    int num = 1;
    int vec[num];
     
    int result = move_num_vec(array, length, &read, &write, num, vec);
    for (int i = 0; i < sizeof(vec)/sizeof(int); i++){
		printf("\nVec: %d", vec[i]);
	}

	printf("\nResult: %d", result);
    printf("\nRead: %d", read);
    printf("\nWrite: %d", write);
	
return 0;
}
