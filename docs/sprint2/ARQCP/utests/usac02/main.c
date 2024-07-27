#include <string.h>  
#include "../../unity.h"
#include "asm.h" 


void call_func ( void (*f)(int* array, int len, int* rd, int* wr, int val),
                           int* array, int len, int* rd, int *wr, int val);  

void setUp(void) {
    // set stuff up here
}

void tearDown(void) {
    // clean stuff up here
}



void run_test(int * array, int len, int rd, int wr, int val, 
			  int * exp_arr, int exp_rd, int exp_wr)
{
    int vec[100];
	// 0 - sentinel  
	// 1 - read 
	// 2 - sentinel  
	// 3 - write 
    // 4 - sentinel 
	// 5 - buffer 
	// 5+length - sentinel 	

    // setup 
    memset(vec, 0x55, sizeof vec);
	memcpy(vec+5,array,len*sizeof(int));  // buffer   
	vec[1]=rd; 
	vec[3]=wr; 

	call_func(enqueue_value,vec+5,len,vec+1,vec+3, val);
    
    TEST_ASSERT_EQUAL_INT(0x55555555, vec[0]);    // check sentinel 
    TEST_ASSERT_EQUAL_INT(0x55555555, vec[2]);    // check sentinel  
    TEST_ASSERT_EQUAL_INT(0x55555555, vec[4]);    // check sentinel  
    TEST_ASSERT_EQUAL_INT(0x55555555, vec[len+5]);    // check sentinel  
    TEST_ASSERT_EQUAL_INT_ARRAY(exp_arr, vec+5, len);    // check buffer 
    TEST_ASSERT_EQUAL_INT(exp_rd, vec[1]);    // check read   
    TEST_ASSERT_EQUAL_INT(exp_wr, vec[3]);    // check write  
    
}


void test_One()
{
    run_test((int[]){0,0,0},3,0,0,5,(int[]){5,0,0},0,1);
}
void test_Zero()
{
    run_test((int[]){0,0,0},3,0,2,5,(int[]){0,0,5},1,0);
}
void test_Three()
{
    run_test((int[]){0,0,0,0},4,3,3,5,(int[]){0,0,0,5},3,0);
}
void test_Five()
{
    run_test((int[]){0,0,0,0},4,0,3,5,(int[]){0,0,0,5},1,0);
}

void test_Six()
{
    run_test((int[]){0,0,0},3,0,2,5,(int[]){0,0,5},1,0);
}

void test_Seven()
{
    run_test((int[]){-1,-2,-3},3,0,1,2,(int[]){-1,2,-3},0,2);
}

void test_Eight()
{
    run_test((int[]){2,3,3},3,0,2,1,(int[]){2,3,1},1,0);
}

void test_Nine()
{
    run_test((int[]){1,1,1,10,4},5,0,2,4,(int[]){1,1,4,10, 4},0,3);
}
void test_Ten()
{
    run_test((int[]){2, 7, 14, 8, 21}, 5, 2, 3, 17, (int[]){2, 7, 14, 17, 21}, 2, 4);
}

void test_Eleven()
{
    run_test((int[]){11, 6, 22, 14, 8}, 5, 1, 4, -5, (int[]){11, 6, 22, 14, -5}, 1, 0);
}

void test_Twelve()
{
    run_test((int[]){30, 18, 7, 12, 25}, 5, 3, 2, 10, (int[]){30, 18, 10, 12, 25}, 4, 3);
}

void test_Thirteen()
{
    run_test((int[]){9, 16, 22, 35, 11}, 5, 4, 0, -7, (int[]){-7, 16, 22, 35, 11}, 4, 1);
}

void test_Fourteen()
{
    run_test((int[]){19, 14, 27, 8, 22}, 5, 0, 1, 30, (int[]){19, 30, 27, 8, 22}, 0, 2);
}

void test_Fifteen()
{
    run_test((int[]){5, 11, 17, 20, 13}, 5, 2, 2, -3, (int[]){5, 11, -3, 20, 13}, 2, 3);
}

void test_Sixteen()
{
    run_test((int[]){9, 24, 18, 11, 27, 32}, 6, 5, 2, 15, (int[]){9, 24, 15, 11, 27, 32}, 5, 3);
}
int main()
  { 

    UNITY_BEGIN();
    RUN_TEST(test_One);
    RUN_TEST(test_Zero);
    RUN_TEST(test_Three);
      RUN_TEST(test_Five);
      RUN_TEST(test_Six);
      RUN_TEST(test_Seven);
      RUN_TEST(test_Eight);
      RUN_TEST(test_Nine);
      RUN_TEST(test_Ten);
      RUN_TEST(test_Eleven);
      RUN_TEST(test_Twelve);
      RUN_TEST(test_Thirteen);
      RUN_TEST(test_Fourteen);
      RUN_TEST(test_Fifteen);
      RUN_TEST(test_Sixteen);
    return UNITY_END();

  } 






