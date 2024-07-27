#ifndef ASM_H
#define ASM_H
#include <string.h>

int mediana(int* , int);
int extract_token(char* input, char* token, int* output);

typedef struct s_buffer {
    int* circle_buffer;
    unsigned int length;
    unsigned int read;
    unsigned int write;
} buffer;

typedef struct s_median{
    int* medianArray;
    unsigned int window;
} median;

typedef struct s_sensor {
    unsigned int ID;
    char type[50];
    char unit[50];
    buffer buffer;
    median medianArray;
    int mediana;
    unsigned int timestamp;
    unsigned int timeout;
    int write_counter;
} sensor;


int serialize(sensor*, int, const char* );
float readDataFromColetorDeDados(const char* serialPortPath);
void fillSensorWithData(const char* serialPortPath, sensor* s);

#endif
