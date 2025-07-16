#ifndef TREE_H
#define TREE_H



typedef struct TreeNode {
    int value;
    struct  TreeNode* left;
    struct  TreeNode* right;
}TreeNode;

// insert left most in order
TreeNode* insert(TreeNode* root, int value);

// search a node in tree
TreeNode * search(TreeNode* root, int value);

// delete a node from tree
TreeNode* delete(TreeNode* root, int value);

// print tree in inorder
void inorder(TreeNode* root);
TreeNode * mins(TreeNode *root);
//remove from memory
void freeTree(TreeNode* root);

TreeNode* createNode(int value) ;
#endif
