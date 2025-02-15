/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:

 TreeNode *BST(vector<int>& preorder, int &index, int lower, int upper)
 {
    //base case
    if(index== preorder.size() || preorder[index]<lower || preorder[index]>upper)
    return nullptr;

    //preorder traversal

    //node 
    TreeNode *root = new TreeNode (preorder[index ++]);
    //left side
    root->left = BST(preorder, index, lower, root->val);
    //right side
    root->right = BST(preorder, index, root->val,upper);

    return root;
 }
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        int index = 0;
        return BST(preorder, index, INT_MIN, INT_MAX);
    }
};