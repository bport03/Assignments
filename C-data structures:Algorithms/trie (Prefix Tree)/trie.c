#include "trie.h"

#include <stdlib.h>
#include <stdbool.h>


TrieNode * createNode() {

    TrieNode * node = malloc(sizeof(TrieNode)); // allocate space
    node->isEndOfWord = 0; // set the end of the word
    // set all index to NULL
    for (int i =0 ; i < 26 ; i++) {
        node->children [i]= NULL;
    }

    return node;
}

// insert the word to the array
void insert(TrieNode* root, const char* word) {

    TrieNode *current = root; // this would set the level of the tree we are workig

    // loop through word and place letters
    // at somepoint i would be pointing at the end we should stop there \0
    for (int i =0 ; word[i]!= '\0';i++) {
        int index= word[i]-'a';  // get the index were we place the letter
        if (current->children[index]== NULL) { // the letter hasnt be added in that index
            current->children[index]=createNode();
        }
        current = current->children[index];


    }
    current->isEndOfWord = 1; // setting that the word has been added and end of the word
}// insert


//checks if a given word exists in the Trie by walking character by
//character through the corresponding child pointers and verifying isEndOfWord at the end.

bool search(TrieNode * root, const char* word) {

    TrieNode* current= root;

    // travel the tree
    for (int i = 0;word[i]!= '\0'; i++) {
        int index = word[i]-'a';

        current=current->children[index];

    }
    if (current->isEndOfWord == 1) return 1;

    return 0;
}

//checks if any word in the Trie begins with a given prefix by walking through
//the Trie nodes for each character in the prefix
bool   startsWith(TrieNode * root,const char* word)// Check if any word starts with a prefix
{
    TrieNode *current = root;

    for (int i = 0;word[i]!= '\0'; i++) {
        int index = word[i]-'a';
        if (current->children[index]==NULL) {
            return 0;
        }
        current=current->children[index];
    }

    return 1;
}
