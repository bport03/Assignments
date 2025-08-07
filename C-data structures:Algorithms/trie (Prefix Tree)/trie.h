#ifndef TRIE_H
#define TRIE_H
#include <stdbool.h>


typedef struct TrieNode {
    struct TrieNode * children[26];
    bool isEndOfWord;
}TrieNode;

void insert(TrieNode* root, const char* word);//  Add a word

bool search(TrieNode * root,const char* word);// Check if a word exists

bool  startsWith(TrieNode * root,const char* word);// Check if any word starts with a prefix

TrieNode * createNode();

#endif