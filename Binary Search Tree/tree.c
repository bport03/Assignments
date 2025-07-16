#include "tree.h"

#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>



// start tree
TreeNode* createNode(int value) {
    TreeNode * node  = malloc(sizeof(TreeNode));
    node->value=value;
    node->left=NULL;
    node->right=NULL;
    return node;

}
// insert left most in order
TreeNode* insert(TreeNode* root, int value) {
        // check if tree is null;
    if (root == NULL) {
        // set both sides to null
        TreeNode *node = createNode(value);
        node->right=NULL;
        node->right=NULL;
        root= node;
        return root;
    }
        // tree is not empty
        if (value <root->value  ) {
            // we go left
            root->left=insert(root->left,value);
        }

        if (value > root->value) {
            // we go left
            root->right=insert(root->right,value);
        }

    return root;

}

// search a node in tree
TreeNode* search(TreeNode* root, int value) {
    // basic case if null return / not been found
    if (root==NULL)
        return root;

    // value has been found
    if (root->value== value)
        return root;
    // recursive call to travel tree
    if (value < root->value) {
        // travel tree to left
        return search(root->left,value);

    } else if  (value > root->value) {
        // travel tree to right
        return search(root->right,value);
    }
    return root;

}



// delete a node from tree
TreeNode* delete(TreeNode* root, int value){
    // basic case if null return / not been found
    if (root == NULL)
        return root;

    // recursive call to travel tree
    if (value < root->value) {
        // travel tree to left
        root->left = delete(root->left,value);


    } else if  (value > root->value) {
        // travel tree to right
        root->right =delete(root->right,value);

    } else {
        // // case if value has been found
        // no children
        if (root->value==value) {
            if (root->left == NULL && root->right == NULL) {
                free(root);
                return NULL;
            }

            // case if one child is not null
            if (root->left == NULL ) {
                TreeNode * temp = root->right;
                free(root);

                return temp;
            }

            if (root->right == NULL ) {
                TreeNode * temp = root->left;
                free(root);

                return temp;

            }
            // case we have two children replace root with thr right subtree left most node
            if (root->left != NULL && root->right != NULL) {
                // find the min of most right tree
                TreeNode * temp = mins(root->right);
                root->value=temp->value;
                root->right=delete(root->right,temp->value);
                return root;

            }
        }
    }
    return root;

}

// find the min number from the righ subtree
TreeNode* mins(TreeNode* root) {

    while (root && root->left!= NULL ) {
        root= root->left;
    }

    return root;
}
// print tree in inorder
void inorder(TreeNode* root) {

    if (root==NULL)return;
    inorder(root->left);
    printf("%d  ", root->value);
    inorder(root->right);
}


