// Brandon Portillo
// PA 1: Simple C Aliasing Problem
// FEB-7-2023
#include <stdio.h>


int main() {
    int A[100];
    char *S;
    // fill out array with ASCII of your name
    A[0] = (66) + (114 * 256) + (97 * 256 * 256) + (110 * 256 * 256 * 256);
    A[1] = (100) + (111 * 256) + (110* 256 * 256)+(32* 256 * 256 * 256);
    A[2]= (80) + (111*256) + (114* 256*256)+ (116* 256 * 256 * 256);
    A[3]=(105) + (108* 256) + (108* 256*256)+ (111* 256 * 256 * 256);
    A[4]=(0);


    // cast the array into a printing string
    S= (char *) &A;
    printf("My name is %s\n",S);

    return 0;
}