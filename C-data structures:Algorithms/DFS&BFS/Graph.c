#include "Graph.h"

#include <stdio.h>
#include <stdlib.h>


Graph * createGraph(int numVertices) {

    Graph* graph = malloc(sizeof(Graph));
    graph->numVertices=numVertices;
    graph->adjLists = malloc(numVertices *sizeof(Node*));
    for (int i =0 ;i <numVertices;i++) {
        graph->adjLists[i]=NULL;
    }
    return  graph;
}

Graph * addEdge (Graph * graph, int src, int dest) {
    // create a new node that represents destination
    // this would aslo add a edge from src to dest
    Node * newNode= malloc(sizeof(Node));
    newNode->vertex=dest;
    newNode->next=graph->adjLists[src];
   graph->adjLists[src]=newNode;
    // in this section we would add edge from dest to src
    Node* reverseNode = malloc(sizeof(Node));
    reverseNode->vertex=src;
    reverseNode->next=graph->adjLists[dest];
    graph->adjLists[dest]=reverseNode;
    return graph;
}


void DFS_Util(Graph* graph, int startVertex, int *visited) {
    visited[startVertex]=1;
    printf("%d \n",startVertex);
    Node * temp = graph->adjLists[startVertex];
    while (temp!=NULL) {
        int neighbor = temp->vertex;
        if (!visited[neighbor]) {
            DFS_Util(graph,neighbor,visited);
        }
        temp=temp->next;
    }
}

void DFS (Graph * graph , int startVertex) {
    int * visted = malloc(graph->numVertices*sizeof(int));
    // initialize all vetices as not visited
    for (int i =0 ; i < graph->numVertices;i++) {
        visted[i]=0;
    }
    DFS_Util(graph,startVertex,visted);
    free(visted);
}

void BFS(Graph *graph, int startVertex) {

    int * visted = malloc(graph->numVertices*sizeof(int));
    // initialize all vetices as not visited
    for (int i =0 ; i < graph->numVertices;i++) {
        visted[i]=0;
    }
    int front=0;
    int end=0;
    int * queue = malloc(graph->numVertices*sizeof(int));
    visted[startVertex]=1;
    end++;

    while (front < end) {
        int current = queue[front++];
        Node* temp = graph->adjLists[current];
        printf("%d \n", current);
        while (temp!=NULL) {
            int neighbor = temp->vertex;
            if (visted[neighbor] == 0) {
                visted[neighbor]=1;
                queue[end++]=neighbor;
            }
            temp=temp->next;
        }
    }
}
