#include "structs.h"
#include <stdio.h>
#include <time.h>

int serialize (sensor* ptr, int lines, const char* folder) {
	
	time_t t = time(NULL);
    struct tm tm_info = *localtime(&t);

    char formatted_date[15]; 
    sprintf(formatted_date, "%04d%02d%02d%02d%02d%02d",
            tm_info.tm_year + 1900, tm_info.tm_mon + 1, tm_info.tm_mday,
            tm_info.tm_hour, tm_info.tm_min, tm_info.tm_sec);
	

    char file_name[25]; 
    sprintf(file_name, "%s/%s_sensors.txt", folder, formatted_date);

    FILE *file = fopen(file_name, "w");
    if (file == NULL) {
        fprintf(stderr, "Erro ao criar o arquivo.\n");
        return 1;
    }

    // Escrever no arquivo (pode ser deixado em branco)
    
    for (int i = 0; i < lines; i++) {
		long rightNow = t * 1000;
		long timeError = rightNow - ptr[i].timestamp;
		
		
		if(timeError >= ptr[i].timeout){fprintf(file, "%d,%d,%s,%s,error#\n", ptr[i].ID, ptr[i].write_counter, ptr[i].type, ptr[i].unit);}
		else {
			if(ptr[i].mediana!=-1){ fprintf(file, "%d,%d,%s,%s,%d#\n", ptr[i].ID, ptr[i].write_counter, ptr[i].type, ptr[i].unit),ptr[i].mediana;}
			}
		
		ptr[i].mediana=-1;

        //printf("%d - %d\n",i,mediana(ptr[i].medianArray.medianArray,(sizeof(ptr[i].medianArray.medianArray)/sizeof(ptr[i].medianArray.medianArray[0]))));
        //ptr[i].write_counter +=1;
    }
    
    // Fechar o arquivo
    fclose(file);

    printf("Arquivo '%s' criado com sucesso .\n", file_name);
	
		
    return 0;

}
