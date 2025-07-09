#include <stdio.h>
#include <stdlib.h>

#include "link.h"

int main(void) {
    // call list
    List *list = createList();
    insertFront(list, 10);
    insertFront(list, 20);
    insertFront(list, 30);
    printForward(list);
    printf("\n");
    insertBack(list,400);
    printForward(list);
    printf("\n");
    removeFront(list);
    printForward(list);
    printf("\n");
    removeBack(list);
    printf("\n");
    printForward(list);
}