#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include "structs.h"

float readDataFromColetorDeDados(const char* serialPortPath) {
    int serial_port = open(serialPortPath, O_RDONLY);
    if (serial_port == -1) {
        printf("Falha ao abrir a serial port.\n");
        exit(1);
    }

    // Read data from the serial port
    char buffer[256];
    ssize_t bytesRead = read(serial_port, buffer, sizeof(buffer));
    if (bytesRead == -1) {
        perror("Falha ao ler informação a serial port");
        exit(1);
    }

    // Close the serial port
    close(serial_port);

    // Convert the read data to float
    float value = atof(buffer);

    return value;
}

