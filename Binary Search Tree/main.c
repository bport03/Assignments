#include <stdio.h>
#include "tree.h"
int main(void) {

    TreeNode * tree=NULL;
    tree=insert(tree,10);
    tree=insert(tree,8);
    tree=insert(tree,9);
    tree=insert(tree,11);
    tree=insert(tree,1);
    tree=insert(tree,2);
    tree=insert(tree,4);
    tree=insert(tree,7);
    tree=insert(tree,6);

    inorder(tree);
    TreeNode* tree1= NULL;
    printf("\n\n");
    tree = delete(tree,8);
    inorder(tree);

}