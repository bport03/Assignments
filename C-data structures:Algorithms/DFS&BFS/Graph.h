#ifndef  GRAPH_H
#define GRAPH_H

typedef struct Node {
    int vertex; // the neighbros index
    struct Node* next; // pointer to the next vertex
}Node;

typedef struct Graph {
   int numVertices; // total vertices count
    Node ** adjLists; // an array of pointers to the Node
}Graph;


Graph* createGraph(int numVertices);
void DFS (Graph * graph , int startVertex);
void DFS_Util(Graph* graph, int startVertex, int *Visited);
Graph * addEdge (Graph * graph, int src, int dest);
void BFS (Graph * graph, int startVertex);
#endif
