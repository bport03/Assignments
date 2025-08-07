#include <stdio.h>
#include "trie.h"
int main(void) {
    TrieNode* root = createNode();  // 🔹 Step 1: create Trie root

    insert(root, "apple");          // 🔹 Step 2: insert words
    insert(root, "app");
    insert(root, "bat");
   bool i = search(root,"bat");
    if (i ==1 ) {
        printf("yes");
    }else {
        printf("no");
    }
    bool o = startsWith(root,"ap");
    printf("\n\n");
    if (o == 1 ) {
        printf("yes");
    }else {
        printf("no");
    }

    return 0;
}