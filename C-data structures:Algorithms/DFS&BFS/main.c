#include <stdio.h>
#include "Graph.h"
int main(void) {
    Graph* graph = createGraph(5);

    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);

    printf("DFS starting from vertex 0:\n");
    DFS(graph, 0);
    printf("\n\n\n");
    BFS(graph,0);

}