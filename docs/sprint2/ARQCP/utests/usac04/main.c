#include <string.h>  
#include "../../unity.h"
#include "asm.h" 


void call_func ( void (*f)(int* ptr, int num),int* ptr, int num);  

void setUp(void) {
    // set stuff up here
}

void tearDown(void) {
    // clean stuff up here
}



void run_test(int * vec, int in_num, int * exp_vec)
{
    int vec1[100];


    // setup 
        memset(vec1, 0x55, sizeof vec1);
     
	memcpy(vec1+1,vec,in_num*sizeof(int));  //   
	call_func(sort_array,vec1+1,in_num);
    
    TEST_ASSERT_EQUAL_INT(0x55555555, vec1[in_num+1]);    // check sentinel 
    TEST_ASSERT_EQUAL_INT(0x55555555, vec1[0]);    // check sentinel  
    if ( in_num != 0 ) 
    TEST_ASSERT_EQUAL_INT_ARRAY(exp_vec, vec1+1, in_num);    // check vec 
    
}


void test_NullVector()
{ 
    run_test((int[]){0},0,(int[]){0}); 
}
void test_One()
{ 
    run_test((int[]){1000},1,(int[]){1000}); 
}
void test_Zero()
{ 
    run_test((int[]){10,0,1},3,(int[]){0,1,10}); 
}
void test_Three()
{ 
    run_test((int[]){-1,-3,-2},3,(int[]){-3,-2,-1}); 
}
void test_Five()
{ 
    run_test((int[]){1,1,1,1,2},5,(int[]){1,1,1,1,2}); 
}
void test_Six()
{
    run_test((int[]){1, 6, 12, 4, 57}, 5, (int[]){1, 4, 6, 12, 57});
}

void test_Seven()
{
    run_test((int[]){3, 8, 14, 9, 22}, 5, (int[]){3, 8, 9, 14, 22});
}

void test_Eight()
{
    run_test((int[]){10, 5, 18, 27, 13}, 5, (int[]){5, 10, 13, 18, 27});
}

void test_Nine()
{
    run_test((int[]){7, 20, 15, 11, 26}, 5, (int[]){7, 11, 15, 20, 26});
}

void test_Ten()
{
    run_test((int[]){30, 25, 19, 16, 23}, 5, (int[]){16, 19, 23, 25, 30});
}

void test_Eleven()
{
    run_test((int[]){2, 13, 28, 17, 21}, 5, (int[]){2, 13, 17, 21, 28});
}

void test_Twelve()
{
    run_test((int[]){14, 8, 6, 23, 10}, 5, (int[]){6, 8, 10, 14, 23});
}

void test_Thirteen()
{
    run_test((int[]){9, 16, 31, 25, 12}, 5, (int[]){9, 12, 16, 25, 31});
}

void test_Fourteen()
{
    run_test((int[]){19, 14, 27, 8, 22}, 5, (int[]){8, 14, 19, 22, 27});
}

void test_Fifteen()
{
    run_test((int[]){5, 11, 17, 20, 13}, 5, (int[]){5, 11, 13, 17, 20});
}
void test_Sixteen()
{
    run_test((int[]){9, 24, 18, 11, 27, 32}, 6, (int[]){9, 11, 18, 24, 27, 32});
}

void test_Seventeen()
{
    run_test((int[]){14, 8, 21, 33, 19, 27}, 6, (int[]){8, 14, 19, 21, 27, 33});
}

void test_Eighteen()
{
    run_test((int[]){25, 17, 30, 14, 22, 8}, 6, (int[]){8, 14, 17, 22, 25, 30});
}

void test_Nineteen()
{
    run_test((int[]){6, 19, 15, 27, 11, 22}, 6, (int[]){6, 11, 15, 19, 22, 27});
}

void test_Twenty()
{
    run_test((int[]){12, 28, 24, 17, 8, 21}, 6, (int[]){8, 12, 17, 21, 24, 28});
}
void test_TwentyOne()
{
    run_test((int[]){-1, 6, -12, 4, -57, -9}, 6, (int[]){-57, -12, -9, -1, 4, 6});
}

void test_TwentyTwo()
{
    run_test((int[]){-3, 8, -14, 9, -22, 16}, 6, (int[]){-22, -14, -3, 8, 9, 16});
}

void test_TwentyThree()
{
    run_test((int[]){10, -5, -18, -27, -13, 22}, 6, (int[]){-27, -18, -13, -5, 10, 22});
}

void test_TwentyFour()
{
    run_test((int[]){7, -20, -15, -11, 26, -2}, 6, (int[]){-20, -15, -11, -2, 7, 26});
}

void test_TwentyFive()
{
    run_test((int[]){-30, 25, -19, -16, 23, -8}, 6, (int[]){-30, -19, -16, -8, 23, 25});
}

void test_TwentySix()
{
    run_test((int[]){-2, 13, 28, -17, 21, -6}, 6, (int[]){-17, -6, -2, 13, 21, 28});
}
int main()
  { 

    UNITY_BEGIN();
    RUN_TEST(test_NullVector);
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
      RUN_TEST(test_Nineteen);
      RUN_TEST(test_Twenty);
      RUN_TEST(test_TwentyOne);
      RUN_TEST(test_TwentyTwo);
      RUN_TEST(test_TwentyThree);
      RUN_TEST(test_TwentyFour);
      RUN_TEST(test_TwentyFive);
      RUN_TEST(test_TwentySix);
    return UNITY_END();

  } 






