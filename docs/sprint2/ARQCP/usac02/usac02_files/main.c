#include <stdio.h>
#include "asm.h"


int print_buffer(int array[], int read, int write, int i){
    char b[255] = "                                                                                                                            ";
    if(write == read) {
        b[26+(write)*12] = 'R';
        b[27+(write)*12] = 'W';
        b[28+(write)*12] = '^';
    }
    else {
        b[27+(write)*12] = 'W';
        b[28+(write)*12] = '^';
        b[27+(read)*12] = 'R';
        b[28+(read)*12] = '^';
    }
    printf("==========================================================================================\n");
    printf("[i:%2d, r:%d, w:%d],{%+011d,%+011d,%+011d,%+011d,%+011d,%+011d}\n", i, read, write,array[0],array[1],array[2],array[3],array[4],array[5]);
    printf("%s\n",b);
    return 0;
}
int print_buffer_small(int array[], int read, int write, int length){
    char b[255] = "                                                                                                                            ";
    if(length !=0) {
        //b[1 + (write) * 7] = '-';
        //b[2 + (write) * 7] = '-';
        //b[3 + (write) * 7] = '-';
        //b[4 + (write) * 7] = '-';
        //b[5 + (write) * 7] = '-';
        //b[6 + (write) * 7] = '-';

        //b[1 + (read) * 7] = '-';
        //b[2 + (read) * 7] = '-';
        //b[3 + (read) * 7] = '-';
        //b[4 + (read) * 7] = '-';
        //b[5 + (read) * 7] = '-';
        //b[6 + (read) * 7] = '-';
        if (write == read) {
            b[4 + (write) * 7] = 'R';
            b[5 + (write) * 7] = 'W';
            b[6 + (write) * 7] = '^';
        } else {
            b[5 + (write) * 7] = 'W';
            b[6 + (write) * 7] = '^';
            b[5 + (read) * 7] = 'R';
            b[6 + (read) * 7] = '^';
        }
    } else {
        b[0] = 0;
    }
    printf("=================================================\n{");
//    printf("{%+06d,%+06d,%+06d,%+06d,%+06d,%+06d}\n", array[0],array[1],array[2],array[3],array[4],array[5]);
    for (int i = 0; i < length; ++i) {
        printf("%+6d",array[i]);
        if (i != length-1) printf(",");
    }
    printf("}\n%s\n",b);
    return 0;
}
int main() {
    int array[]={0,0,0,0};
    int length = 4;
    int read = 0;
    int write = 3;
    printf("Opção 1\n");
    print_buffer_small(array, read, write,length);
//    for (int i = 0; i < 15; ++i) {
        enqueue_value(array, length, &read, &write, 5);
        print_buffer_small(array, read, write,length);
//    }

//    int array_2[]={0,0,0,0,0,0};
//    length = 6;
//    read = 0;
//    write = 0;
//    printf("Opção 2\n");
//    for (int i = 0; i < 15; ++i) {
//        print_buffer(array_2, read, write);
//        enqueue_value_2(array_2, length, &read, &write, i);
//    }
    return 0;
}