#include <string.h>  
#include "../../unity.h"
#include "asm.h" 


int call_func ( int (*f)(int* ptr, int num),int* ptr, int num);  

void setUp(void) {
    // set stuff up here
}

void tearDown(void) {
    // clean stuff up here
}



void run_test(int * vec, int in_num, int  exp_med)
{
    int vec1[100];

	int res; 


    // setup 
        memset(vec1, 0x55, sizeof vec1);
     
	memcpy(vec1+1,vec,in_num*sizeof(int));  //   
	res=call_func(mediana,vec1+1,in_num);
    
    TEST_ASSERT_EQUAL_INT(0x55555555, vec1[in_num+1]);    // check sentinel 
    TEST_ASSERT_EQUAL_INT(0x55555555, vec1[0]);    // check sentinel  
    TEST_ASSERT_EQUAL_INT(exp_med, res);    // check vec 
    
}


void test_NullVector()
{ 
    run_test((int[]){0},0,0); 
}
void test_One()
{ 
    run_test((int[]){1000},1,1000); 
}
void test_Zero()
{ 
    run_test((int[]){10,0,1},3,1); 
}
void test_Three()
{ 
    run_test((int[]){-1,-3,-2},3,-2); 
}
void test_Four()
{ 
    run_test((int[]){-1,-3,-4,-2},4,-2); 
}
void test_Five()
{ 
    run_test((int[]){1,1,1,1,2},5,1); 
}
void test_Six()
{
    run_test((int[]){1, 6, 12, 4, 57}, 5, 6);
}

void test_Seven()
{
    run_test((int[]){3, 8, 14, 9, 22}, 5, 9);
}

void test_Eight()
{
    run_test((int[]){10, 5, 18, 27, 13}, 5, 13);
}

void test_Nine()
{
    run_test((int[]){7, 20, 15, 11, 26}, 5, 15);
}

void test_Ten()
{
    run_test((int[]){25, 19, 16, 23}, 4, 23);
}

void test_Eleven()
{
    run_test((int[]){2, 13, 17, 21}, 4, 17);
}

void test_Twelve()
{
    run_test((int[]){14, 8, 6}, 3, 8);
}

void test_Thirteen()
{
    run_test((int[]){9, 16, 31, 25, 12,17}, 6, 17);
}

int main()
  { 

    UNITY_BEGIN();
    RUN_TEST(test_NullVector);
    RUN_TEST(test_One);
    RUN_TEST(test_Zero);
    RUN_TEST(test_Three);
    RUN_TEST(test_Four);
    RUN_TEST(test_Five);
      RUN_TEST(test_Six);
      RUN_TEST(test_Seven);
      RUN_TEST(test_Eight);
      RUN_TEST(test_Nine);
      RUN_TEST(test_Ten);
      RUN_TEST(test_Eleven);
      RUN_TEST(test_Twelve);
      RUN_TEST(test_Thirteen);
    return UNITY_END();  

  } 






