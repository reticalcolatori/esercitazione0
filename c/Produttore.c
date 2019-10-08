#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

//produttore filedascrivere.txt

#define INV_ERR 1
#define OPEN_ERR 2
#define WR_ERR 3

int main(int argc, char *argv[]){

    if(argc != 2){
        perror("Invocazione: produttore filedascrivere.txt");
        exit(INV_ERR);
    }

    int fd = open(argv[1], O_WRONLY | O_CREAT | O_TRUNC, 0640);
    if(fd < 0){
        perror("P0: Impossibile creare/aprire il file");
        exit(OPEN_ERR);
    }

    //leggo fino ad EOF
    char ch;
    while((read(0, &ch, sizeof(char))) > 0){
        if(write(fd, &ch, sizeof(char)) < 0){
            perror("P0: Errore scrittura nel file");
            exit(WR_ERR);
        }
    }

    close(fd);
    exit(0);
}