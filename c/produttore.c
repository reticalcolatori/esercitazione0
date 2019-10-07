#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define MAX_STRING_LENGTH 256


int main(int argc, char **argv){

    int fd, readValues, written; 
    //int righe, i;

    int x;
    char ch;

    char *file_out;

    //char buf[MAX_STRING_LENGTH];
    //char riga[MAX_STRING_LENGTH];


    //Controllo argomenti
    if(argc != 2){
        perror("Numero di argomenti sbagliato ..."); 
        exit(EXIT_SUCCESS);
    }

    file_out = argv[1];
    
    fd = open(file_out, O_WRONLY|O_CREAT|O_TRUNC, 00640);

    if (fd < 0){   
        perror("P0: Impossibile creare/aprire il file");  
        exit(EXIT_FAILURE);
    }

    //Utilizzo un filtro a carattere.
    while((x = getchar()) != EOF)
    {
        ch = (char)x;
        written = write(fd, &ch, sizeof(char));

        if(written < 0)
        {
            perror("P0: errore nella scrittura sul file");
            exit(2);
        }
    }

    close(fd);

    return 0;
}