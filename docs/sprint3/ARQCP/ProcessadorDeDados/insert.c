#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include "structs.h"

void fillSensorWithData(const char* serialPortPath, sensor* s) {
    for (int i = 0; i < s->write_counter; ++i) {
        float valueReadFromSensor = readDataFromColetorDeDados(serialPortPath);

        s->buffer.circle_buffer[s->buffer.write] = valueReadFromSensor;
        s->buffer.write = (s->buffer.write + 1) % s->buffer.length;

        s->write_counter++;
    }
}

