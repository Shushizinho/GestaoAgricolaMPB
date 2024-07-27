#include <stdio.h>

extern void extract_token(char* input, char* token, int* output);
//char* input, char* token, int* output
int main() {
	
	char input[] = "sensor_id:81#type:atmospheric_temperature#value:29.60#unit:celsius#time:2470031";
	char token[] = "value";
	int value = 0;
	int *output = &value;
	extract_token(input,token,output);
    
    printf("Value extracted for token : %d\n",*output);

    return 0;
}
