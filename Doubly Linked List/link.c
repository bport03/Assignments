#include "link.h"
#include <stdio.h>
#include <stdlib.h>

// Core operations
List* createList() {
    // create the start of the link by setting an empty node
   List *list = malloc(sizeof(List));
    list->head = NULL;
    list->tail =NULL;
    list->size = 0;
    return list;

}// end create list

//insert and head
void insertFront(List* list, int value) {
    // create node

    Node *newNode= malloc(sizeof(Node));
    newNode->value= value;
    newNode->prev=NULL;

    if (list->head==NULL) {
        // the list is empty
        newNode->next=NULL;
        list->head=newNode;
        list->tail=newNode;
    }else {
        // list is not empty
        newNode->next=list->head; // we append new node to the front
        list->head->prev = newNode; // link backwards
        list->head=newNode;

    }
    list->size+=1;

}

// insert at tail;
void insertBack(List* list, int value) {
    //create node
    Node *newNode= malloc(sizeof(Node));
    newNode->value= value;
    newNode->next=NULL;

    // set the head and tail to new node
    if (list->head == NULL) {
        // list was null
        newNode->prev=NULL;
        list->head=newNode;
        list->tail=newNode;
    } else {
        // list is not null
        newNode->prev = list->tail;
        list->tail->next=newNode;
        list->tail=newNode;
    }
    list->size+=1;
}

// remove from head
void removeFront(List* list) {
    if (list->head == NULL) {
        return;
    }

    Node* temp = list->head;

    if (list->head == list->tail) {
        // Only one node in the list
        list->head = NULL;
        list->tail = NULL;
    } else {
        list->head = list->head->next;
        list->head->prev = NULL;
    }

    free(temp);  // 🧹 Free removed node
    list->size -= 1;
}


// remove from tail
void removeBack(List* list) {
    if (list->tail == NULL) {
        return;
    }

    Node* temp = list->tail;

    if (list->head == list->tail) {
        // Only one node in the list
        list->head = NULL;
        list->tail = NULL;
    } else {
        list->tail = list->tail->prev;
        list->tail->next = NULL;
    }

    free(temp);
    list->size -= 1;
}

// Printing list startimg from head
void printForward(List* list) {

    Node* node= list->head;

    while (node!=NULL) {
        printf("%d ",node->value);
        node=node->next;
    }

}
// print list starting from tai;
void printBackward(List* list) {

    Node* node= list->tail;

    while (node!=NULL) {
        printf("%d ",node->value);
        node=node->prev;
    }
}


// return value of index given
int get(List* list, int index) {
    if (index < 0 || index >= list->size) {
        return -1;  // Out of bounds
    }

    Node* current = list->head;
    for (int i = 0; i < index; i++) {
        current = current->next;
    }

    return current->value;
}
