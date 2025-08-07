#ifndef LINK_H
#define LINK_H

typedef struct Node {
    int value;
    struct Node* prev;
    struct Node * next;
}Node;

typedef struct {
    Node* head;
    Node* tail;
    int size;
} List;



// Core operations
List* createList();

void insertFront(List* list, int value);
void insertBack(List* list, int value);

void removeFront(List* list);
void removeBack(List* list);

int get(List* list, int index);

// Printing
void printForward(List* list);
void printBackward(List* list);




#endif
