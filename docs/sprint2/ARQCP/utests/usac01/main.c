#include <string.h>  
#include "../../unity.h"
#include "asm.h" 


void call_func ( void (*f)(char* str,char* tok, int* out),char* str,char *tok, int* out);  

void setUp(void) {
    // set stuff up here
}

void tearDown(void) {
    // clean stuff up here
}



void run_test(char * str, char* tok,  int  exp_res)
{
	int vec[3]={0x55555555,0x55555555,0x55555555}; 


    // setup 
	call_func(extract_token,str,tok,&vec[1]);
    
    TEST_ASSERT_EQUAL_INT(0x55555555, vec[2]);    // check sentinel 
    TEST_ASSERT_EQUAL_INT(0x55555555, vec[0]);    // check sentinel  
    TEST_ASSERT_EQUAL_INT(exp_res, vec[1]);    // check res  
    
}


void test_Null()
{ 
    run_test("","",0x55555555); 
}
void test_One()
{ 
    run_test("sensor_id:8#type:atmospheric_temperature#value:21.60#unit:celsius#time:2470030","sensor_id:",8); 
}
void test_Zero()
{ 
    run_test("sensor_id:8#type:atmospheric_temperature#value:21.60#unit:celsius#time:2470030","zenzor_id:",0x55555555); 
}
void test_Three()
{ 
    run_test("sensor_id:8#type:atmospheric_temperature#value:21.60#unit:celsius#time:2470030","value:",2160); 
}
void test_Four()
{ 
    run_test("sensor_id:8#type:atmospheric_temperature#value:21.60#unit:celsius#time:2470030","time:",2470030); 
}
void test_Five()
{ 
    run_test("sensor_id:8#type:atmospheric_temperature#value:21.60#unit:celsius#time:2470030","atmos:",0x55555555); 
}

void test_Six() {
    run_test("sensor_id:123#type:humidity#value:45.80#unit:percent#time:123456", "value:", 4580);
}

void test_Seven() {
    run_test("sensor_id:42#type:pressure#value:1015.30#unit:hPa#time:987654", "type:", 0x55555555);
}

void test_Eight() {
    run_test("sensor_id:99#type:wind_speed#value:15.75#unit:m/s#time:555555", "unit:", 0x55555555);
}

void test_Nine() {
    run_test("sensor_id:555#type:temperature#value:17.50#unit:celsius#time:888888", "temperature:", 0x55555555);
}

void test_Ten() {
    run_test("sensor_id:777#type:rainfall#value:0.25#unit:inches#time:333333", "rainfall:", 0x55555555);
}

void test_Eleven() {
    run_test("sensor_id:123#type:humidity#value:45.80#unit:percent#time:123456", "percent#", 0x55555555);
}

void test_Twelve() {
    run_test("sensor_id:42#type:pressure#value:1015.30#unit:hPa#time:987654", "pressure#", 0x55555555);
}

void test_Thirteen() {
    run_test("sensor_id:99#type:wind_speed#value:15.75#unit:m/s#time:555555", "wind_speed#", 0x55555555);
}

void test_Fourteen() {
    run_test("sensor_id:555#type:temperature#value:17.50#unit:celsius#time:888888", "value:", 1750);
}

void test_Fifteen() {
    run_test("sensor_id:777#type:rainfall#value:0.25#unit:inches#time:333333", "inches#", 0x55555555);
}

void test_Sixteen() {
    run_test("sensor_id:123#type:humidity#value:45.80#unit:percent#time:123456", "humidity#", 0x55555555);
}

void test_Seventeen() {
    run_test("sensor_id:42#type:pressure#value:1015.30#unit:hPa#time:987654", "hPa#", 0x55555555);
}

void test_Eighteen() {
    run_test("sensor_id:99#type:wind_speed#value:15.75#unit:m/s#time:555555", "wind_speed#", 0x55555555);
}

void test_Nineteen() {
    run_test("sensor_id:555#type:temperature#value:17.50#unit:celsius#time:888888", "celsius#", 0x55555555);
}

void test_Twenty() {
    run_test("sensor_id:777#type:rainfall#value:0.25#unit:inches#time:333333", "inches#", 0x55555555);
}

int main() {
    UNITY_BEGIN();
    RUN_TEST(test_Null);
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
    RUN_TEST(test_Fourteen);
    RUN_TEST(test_Fifteen);
    RUN_TEST(test_Sixteen);
    RUN_TEST(test_Seventeen);
    RUN_TEST(test_Eighteen);
    RUN_TEST(test_Nineteen);
    RUN_TEST(test_Twenty);
    return UNITY_END();
}



