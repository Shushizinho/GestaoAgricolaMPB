#include <string.h>  
#include "../../unity.h"
#include "asm.h" 


int call_func ( int (*f)(int* array, int len, int* rd, int* wr, int num, int* vec ),
                          int* array, int len, int* rd, int *wr, int num, int* vec );  

void setUp(void) {
    // set stuff up here
}

void tearDown(void) {
    // clean stuff up here
}



void run_test(int * array, int len, int rd, int wr, int num, 
			  int exp_res, int * exp_vec, int exp_rd, int exp_wr)
{
    int v1[100];
	// 0 - sentinel  
	// 1 - read 
	// 2 - sentinel  
	// 3 - write 
    // 4 - sentinel 
	// 5 - buffer 
	// 5+length - sentinel 	

    // setup 
    memset(v1, 0x55, sizeof v1);
	memcpy(v1+5,array,len*sizeof(int));  // buffer   
	v1[1]=rd; 
	v1[3]=wr; 
	
	int v2[100]; 
    memset(v2, 0x55, sizeof v2);    // destination 
    int res; 
	res=call_func(move_num_vec, v1+5, len, v1+1, v1+3, num, v2+1);
    TEST_ASSERT_EQUAL_INT(exp_res,res);    // check result 
    TEST_ASSERT_EQUAL_INT(0x55555555, v1[0]);    // check sentinel
    TEST_ASSERT_EQUAL_INT(0x55555555, v1[2]);    // check sentinel  
    TEST_ASSERT_EQUAL_INT(0x55555555, v1[4]);    // check sentinel  
    TEST_ASSERT_EQUAL_INT(0x55555555, v1[len+5]);    // check sentinel
    TEST_ASSERT_EQUAL_INT_ARRAY(array, v1+5, len);    // check buffer 
    TEST_ASSERT_EQUAL_INT(exp_rd, v1[1]);    // check read
    TEST_ASSERT_EQUAL_INT(exp_wr, v1[3]);    // check write
    // output vector  
    TEST_ASSERT_EQUAL_INT(0x55555555, v2[0]);    // check sentinel 
    TEST_ASSERT_EQUAL_INT(0x55555555, v2[num+1]);    // check sentinel  
    if (exp_res==1) 
    	TEST_ASSERT_EQUAL_INT_ARRAY(exp_vec,v2+1, num); 
		// check output
	else 
    	TEST_ASSERT_EQUAL_INT(0x55555555, v2[1]);    // check output 
}
// void run_test(int * array, int len, int rd, int wr, int num, 
//			  int exp_res, int * exp_vec, int exp_rd, int exp_wr)

void test_One()
{ 
    run_test((int[]){0,0,0},3,0,0,1,0,(int[]){0,0,0},0,0); 
}
void test_Zero()
{ 
    run_test((int[]){1,0,0},3,0,1,1,1,(int[]){1},1,1); 
}
void test_Three()                                            
{ 
    run_test((int[]){1,2,3,4},4,3,2,3,1,(int[]){4,1,2},2,2); 
}
void test_Five()
{ 
    run_test((int[]){1,2,3,4},4,2,1,3,1,(int[]){3,4,1},1,1); 
}


void test_Six()
{
    run_test((int[]){-5, 8, -12, 4, -7}, 5, 1, 4, 3, 1, (int[]){8,-12,4}, 4, 4);
}

void test_Seven()
{
    run_test((int[]){10, -15, 8, -3, 7}, 5, 2, 4, 2, 1, (int[]){8,-3}, 4, 4);
}

void test_Eight()
{
    run_test((int[]){3, -8, 14, -9, 2}, 5, 3, 1, 3, 1, (int[]){-9,2,3}, 1, 1);
}

void test_Nine()
{
    run_test((int[]){-7, 20, -15, 11, -26}, 5, 3, 4, 6, 0, (int[]){0,0,0,0}, 3, 4);
}

void test_Ten()
{
    run_test((int[]){30, -25, 19, -16, 23}, 5, 1, 1, 4, 0, (int[]){0,0,0,0}, 1, 1);
}

void test_Eleven()
{
    run_test((int[]){2, -13, 28, -17, 21}, 5, 2, 1, 2, 1, (int[]){28,-17}, 4, 1);
}

void test_Twelve()
{
    run_test((int[]){-14, -8, -6, 23, -10}, 5, 3, 4, 7, 0, (int[]){0,0,0,0}, 3, 4);
}

void test_Thirteen()
{
    run_test((int[]){9, -16, 31, -25, 12}, 5, 4, 2, 3, 1, (int[]){12,9,-16}, 2, 2);
}

void test_Fourteen()
{
    run_test((int[]){19, -14, 27, -8, 22}, 5, 1, 3, 2, 1, (int[]){-14,27}, 3, 3);
}

void test_Fifteen()
{
    run_test((int[]){5, -11, -17, -20, 13,25,16,13}, 8, 6, 4, 6, 1, (int[]){16,13,5,-11,-17,-20}, 4, 4);
}

void test_Sixteen()
{
    run_test((int[]){-9, 24, -18, -11, 27, -32}, 6, 2, 5, 3, 1, (int[]){-18,-11,27}, 5, 5);
}

void test_Seventeen()
{
    run_test((int[]){14, -8, 21, -33, 19, -27}, 6, 4, 1, 7, 0, (int[]){0,0,0,0,0,0,0}, 4, 1);
}

void test_Eighteen()
{
    run_test((int[]){25, -17, 30, 14, 22, 8}, 6, 1, 3, 2, 1, (int[]){-17,30}, 3, 3);
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
      RUN_TEST(test_Seventeen);
      RUN_TEST(test_Eighteen);
    return UNITY_END();  

  } 






