#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>
#include <sys/stat.h>
#include "structs.h"


#define MAX_LINE_LENGTH 256


char** splitString(const char* input) {
    int numSubstrings = 1;
    for (int i = 0; input[i] != '\0'; ++i) {
        if (input[i] == '#') {
            numSubstrings++;
        }
    }
    
    char** substrings = (char**)malloc((numSubstrings + 1) * sizeof(char*));
    if (substrings == NULL) {
        perror("Memory allocation error");
        exit(EXIT_FAILURE);
    }

    const char* start = input;
    int index = 0;
    for (int i = 0; input[i] != '\0'; ++i) {
        if (input[i] == '#') {
            int length = i - (start - input);

            substrings[index] = (char*)malloc((length + 1) * sizeof(char));
            if (substrings[index] == NULL) {
                perror("Memory allocation error");
                exit(EXIT_FAILURE);
            }

            strncpy(substrings[index], start, length);
            substrings[index][length] = '\0';

            start = input + i + 1;
            index++;
        }
    }

    int length = strlen(start);
    substrings[index] = (char*)malloc((length + 1) * sizeof(char));
    if (substrings[index] == NULL) {
        perror("Memory allocation error");
        exit(EXIT_FAILURE);
    }
    strcpy(substrings[index], start);

    substrings[numSubstrings] = NULL;

    return substrings;
}
char** getParams(char* inputString) {
    char** substrings = splitString(inputString);
    int sensor_id = atoi(substrings[0]);
    char* type = substrings[1];
    char* unit = substrings[2];
    int buffer_len = atoi(substrings[3]);
    int window_len = atoi(substrings[4]);
    int timeout = atoi(substrings[5]);
    printf("Sensor ID:     %d\n", sensor_id);
    printf("Type:          %s\n", type);
    printf("Unit:          %s\n", unit);
    printf("Buffer Length: %d\n", buffer_len);
    printf("Window Length: %d\n", window_len);
    printf("Timeout:       %d\n", timeout);

    return substrings;
}

sensor* readConfig(char* path, int lines){
    sensor* ptr_sensor = (sensor *) malloc(lines* sizeof(sensor));
    FILE *file = fopen(path, "r");
    if (file == NULL) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }

    char line[MAX_LINE_LENGTH];
    int i = 0;
    while (fgets(line, sizeof(line), file) != NULL) {
        printf("#======================#\nLine: %s\n", line);
        char** params = getParams(line);
        sensor s;
        s.ID = atoi(params[0]);
        strcpy(s.type, params[1]);
        strcpy(s.unit, params[1]);
        s.write_counter = 0;
        buffer b;
        int* circle = (int*)malloc((atoi(params[3])) * sizeof(int));
        b.circle_buffer = circle;
        b.length = atoi(params[3]);
        b.read=0;
        b.write=0;
        s.buffer = b;
        median m;
        m.window = atoi(params[4]);
        printf("m.win:          %d\n", m.window);
        int* medArr = (int*)malloc((m.window ) * sizeof(int));
        m.medianArray = medArr;
        s.medianArray = m;
        s.mediana=-1;
        s.timestamp = 0;
        s.timeout = atoi(params[5]);
        ptr_sensor[i] = s;
        i++;
    }

    fclose(file);
    return ptr_sensor;
}

int getLineNum(char* path){
    FILE *file = fopen(path, "r");
    if (file == NULL) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }

    char line[MAX_LINE_LENGTH];

    int i = 0;
    while (fgets(line, sizeof(line), file) != NULL) {
        i++;
    }
    int* ptr_array = malloc(i* sizeof(int));
    fclose(file);
    return i;
}


int pastaExiste(const char *caminho) {
    DIR *dir = opendir(caminho);

    if (dir != NULL) {
        closedir(dir);
        return 1;  // A pasta existe
    } else {
        return 0;  // A pasta não existe
    }
}


int criarPasta(const char *caminho) {
    int status = mkdir(caminho, S_IRWXU);

    if (status == 0) {
        printf("A pasta \"%s\" foi criada com sucesso.\n", caminho);
        return 1;  // A pasta foi criada com sucesso
    } else {
        printf("Erro ao criar a pasta \"%s\".\n", caminho);
        return 0;  // Falha ao criar a pasta
    }
}

int getIndex(sensor* ptr, int lines, int id){
	int i=0;
	int x=-1;
	int encontrado=0;
	while(i<lines && encontrado==0 ){
		if(ptr[i].ID==id){
			encontrado=1;
			x=i;
		}
		i++;
	}
	return x;
	
}

int main(int argc,char *args[]) {
	
    //args[1] - pasta dos ficheiros do coletor
    //args[2] - config
    //args[3] - pasta para enviar pra saida de dados
    //args[4] - quantas leituras faz antes de enviar pra pasta
    int lines = getLineNum(args[2]);
    sensor* ptr = readConfig(args[2],lines);
    
    char* nomePasta = args[3];
    int numero_leituras =atoi( args[4]);
    
    if (pastaExiste(nomePasta)) {
            printf("A pasta \"%s\" existe.\n", nomePasta);
        } else {
            printf("A pasta \"%s\" não existe. Tentando criar...\n", nomePasta);
            criarPasta(nomePasta);
        }
        
        

    char line[MAX_LINE_LENGTH];
    int i = 0;
     
    do{
		FILE *file = fopen(args[1], "r");
    if (file == NULL) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }
    
		int contador_leitura=0;
		while(contador_leitura<=numero_leituras){

			fgets(line, sizeof(line), file);
			printf(" %d\n",contador_leitura);
			
            int id;
            int value;
            unsigned int dado;
            int* time=&dado;
            
            int sucesso1=extract_token(line,"sensor_id:",&id);
            int sucesso2=extract_token(line,"value:",&value);
            int sucesso3=extract_token(line,"time:",time);
            printf("%d-%d-%d\n",id,value,*time);
            
            int index=getIndex(ptr, lines,id);
         
            printf("%d",index);
            if(index!=-1){
				ptr[index].timestamp=*time;
				
				enqueue_value(ptr[index].buffer.circle_buffer,ptr[index].buffer.length,&(ptr[index].buffer.read),&(ptr[index].buffer.write),value);
			}
            contador_leitura++;

		}
		printf("sai");
		fclose(file);
		
		 for (int i=0; i < lines; i++) {
			printf("%d",i);
            int sucesso=move_num_vec(ptr[i].buffer.circle_buffer, ptr[i].buffer.length,ptr[i].buffer.read,ptr[i].buffer.write, ptr[i].medianArray.window,ptr[i].medianArray.medianArray);
			
			if(sucesso==1){
			
				ptr[i].mediana=mediana(ptr[i].medianArray.medianArray,ptr[i].medianArray.window);
				if(ptr[i].mediana!=-1){
					ptr[i].write_counter++;
				}
			}
        }

        printf("random");
      serialize(ptr, lines, nomePasta);
        printf("random2");
    } while (1);
	
	printf("random3");
    free(ptr);
    return 0;
}
