#ifndef ASM_H
#define ASM_H
#include <string.h>

typedef struct s_buffer {
    int* circle_buffer;
    unsigned int length;
    unsigned int read;
    unsigned int write;
} buffer;
typedef struct s_median{
    int* medianArray;
    unsigned int window;
    unsigned int length;
} median;

typedef struct s_sensor {
    unsigned int ID;
    char type[50];
    char unit[50];
    buffer buffer;
    median medianArray;
    long timestamp;
    unsigned int timeout;
    int write_counter;
} sensor;

#endif
