#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>
#include <sys/stat.h>


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
int getParams(char* inputString) {
    char** substrings = splitString(inputString);
    int sensor_id = atoi(substrings[0]);

    return sensor_id;
}

int** readConfig(char* path, int lines){
    int** ptr_array = (int* *) malloc(2*sizeof(int*));
    int* ptr_median = (int *) malloc(lines* sizeof(int));
    int* ptr_id = (int *) malloc(lines* sizeof(int));
    FILE *file = fopen(path, "r");
    if (file == NULL) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }

    char line[MAX_LINE_LENGTH];
    int i = 0;
    while (fgets(line, sizeof(line), file) != NULL) {
        printf("#======================#\nLine: %s\n", line);
        int id = getParams(line);
        ptr_id[i] = id;
        ptr_median[i] = 0;
        i++;
    }
    ptr_array[0] = ptr_id;
    ptr_array[1] = ptr_median;
    fclose(file);
    return ptr_array;
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
        return 1;
    } else {
        printf("Erro ao criar a pasta \"%s\".\n", caminho);
        return 0;
    }
}

int main(int argc,char *args[]) {
    //args[1] - serializacao do processador
    //args[2] - pasta de saida final
    //args[3] - de quanto em quanto ele le do processador
    //args[4] - config (mesmo q no processador)
    
    int lines = getLineNum(args[4]);
    int** ptr_array = readConfig(args[4],lines);
    
    char* nomePasta = args[2];
    
    
    if (pastaExiste(nomePasta)) {
        printf("A pasta \"%s\" existe.\n", nomePasta);
    } else {
        printf("A pasta \"%s\" não existe. Tentando criar...\n", nomePasta);
        criarPasta(nomePasta);
    }

    for(int i = 0; i < lines; i++){
        printf("%d - %d\n", ptr_array[0][i],ptr_array[1][i]);
    }
    
    return 0;
}
