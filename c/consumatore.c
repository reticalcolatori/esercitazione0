
#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>

#define MAX_STRING_LENGTH 256


int main(int argc, char **argv){

    char *file_in, read_char/*, buf[MAX_STRING_LENGTH]*/;
    int nread;
    int fd;

    //Controllo argomenti
    if(argc != 2){
        perror("Numero di argomenti sbagliato.");
        exit(EXIT_SUCCESS);
    }

    file_in = argv[1];

    fd = open(file_in, O_RDONLY);

    if(fd < 0)
    {
        perror("P0: impossibile aprire il file.");
        exit(1);
    }

    while(nread = read(fd, &read_char, sizeof(char)) > 0){
        putchar(read_char);
    }

    if(nread < 0)
    {
        printf("(PID %d) impossibile leggere dal file %s", getpid(), file_in);
        perror("Errore!");
        close(fd);
        exit(3);
    }

    close(fd);

    return 0;
}