#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/time.h>

//consumatore filterprefix filedaconsumare.txt

#define INV_ERR 1
#define OPEN_ERR 2
#define WR_ERR 3

int main(int argc, char *argv[]){
    struct timeval tv;
    struct timezone tz;
    gettimeofday(&tv, &tz);
    int start = tv.tv_usec;

    if(argc != 3){
        perror("Invocazione: consumatore filterprefix filedaconsumare.txt");
        exit(INV_ERR);
    }

    int fd = open(argv[2], O_RDONLY);
    if(fd < 0){
        perror("P0: Impossibile aprire il file");
        exit(OPEN_ERR);
    }

    char ch;
    int presente = 0;

    while((read(fd, &ch, sizeof(char))) > 0){
        for(int i = 0; i < strlen(argv[1]) && !presente; i++){
            if(argv[1][i] == ch) //se non sono presente nella string prefix allora mi stampi altrimenti mi salti
                presente = 1;
        }
        if(!presente)
            printf("%c", ch);
        
        presente = 0;
    }

    close(fd);

    gettimeofday(&tv, &tz);
    int end = tv.tv_usec;

    printf("Tempo impiegato per l'esecuzione: %d microsec\n", end - start);
    exit(0);
}