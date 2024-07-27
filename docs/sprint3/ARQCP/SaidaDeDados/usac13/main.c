#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include "structs.h"
#include <dirent.h>
#include <sys/stat.h>
#include <time.h>

// Função para converter um valor de sensor em número real com duas casas decimais
float converter_para_numero_real(char string[]) {
    int tamanhoDaString = strlen(string);

        double integer = atoi(string)/100;

        double decimal = atoi(&string[tamanhoDaString-4]);

        double fraction = decimal/100;

        return integer + fraction;

}


void processar_dados(const char *diretorio_entrada, const char *diretorio_saida, const char periodicidade) {
//loop para estar sempre a ler os arquivos
    while(1){
        DIR *dir;
        struct dirent *entry;

        if ((dir = opendir(diretorio_entrada)) == NULL) {
            perror("Erro ao abrir diretório de entrada");
            exit(EXIT_FAILURE);
        }

        // Encontrar o arquivo mais recente no diretório de entrada
        time_t ultima_modificacao = 0;
        char arquivo_mais_recente[255];

        while ((entry = readdir(dir)) != NULL) {
            char caminho_arquivo[255];
            sprintf(caminho_arquivo, "%s/%s", diretorio_entrada, entry->d_name);

            struct stat info;
            if (stat(caminho_arquivo, &info) == 0) {
                if (S_ISREG(info.st_mode) && info.st_mtime > ultima_modificacao) {
                    ultima_modificacao = info.st_mtime;
                    strcpy(arquivo_mais_recente, entry->d_name);
                }
            }
        }

        closedir(dir);

        // Verificar se encontrou algum arquivo
        if (ultima_modificacao == 0) {
            printf("Nenhum arquivo encontrado no diretório de entrada.\n");
            usleep(periodicidade);
            return;
        }

        // Caminho completo do arquivo mais recente
        char caminho_arquivo_mais_recente[255];
        sprintf(caminho_arquivo_mais_recente, "%s/%s", diretorio_entrada, arquivo_mais_recente);

        // Lógica para ler os dados do arquivo mais recente
        FILE *arquivo = fopen(caminho_arquivo_mais_recente, "r");
        if (arquivo == NULL) {
            perror("Erro ao abrir arquivo mais recente");
            exit(EXIT_FAILURE);
        }

        // Lista para armazenar os dados dos sensores
        int[100] dado_sensor;
        struct sensor dados_sensores[100];
        int num_sensores = 0;

        // Lógica para ler e processar os dados do arquivo
        while (fscanf(arquivo, "%d,%d,%49[^,],%49[^,],%49[^#]#", &dados_sensores[num_sensores].sensor_id,
                      &dados_sensores[num_sensores].write_counter, dados_sensores[num_sensores].type,
                      dados_sensores[num_sensores].unit, dados_sensores[num_sensores].mediana) == 5) {
            double value
             if (strcmp(dados_sensores[num_sensores].mediana, "error#\n") != 0){
                int i = 0;
                for (i = 0; i < lines; i++){
                    if (ptr_array[0][i] = &dados_sensores[num_sensores].sensor_id){
                          ptr_array[1][i] = dados_sensores[num_sensores].mediana;
                    }
                }
             }

            num_sensores++;
        }
        fclose(arquivo);

         // Obter a data e hora atual
        time_t rawtime;
        struct tm *info;
        char timestamp[15];

        time(&rawtime);
        info = localtime(&rawtime);

        // Formatar a data e hora de acordo com a convenção
        strftime(timestamp, sizeof(timestamp), "%Y%m%d%H%M%S", info);

        char nome_arquivo[50];
        sprintf(nome_arquivo, "%s%s sensors.txt", diretorio, timestamp);

        // Criar e abrir o arquivo
        FILE *arquivo = fopen(nome_arquivo, "w");

       if (arquivo == NULL) {
           fprintf(stderr, "Erro ao abrir o arquivo.\n");
           return 1;
       }

        // Escrever os dados processados no arquivo de saída
        for (int i = 0; i < num_sensores; i++) {
            fprintf(arquivo, "%d,%d,%s,%s,%s#\n", ptr_array[1][i]/100);
        }

        fclose(arquivo);

        printf("Arquivo criado com sucesso: %s\n", nome_arquivo);
    }

}


int main(int argc,char *args[]) {

    processar_dados(args[1], args[2], agrs[3]);

    return 0;
}


