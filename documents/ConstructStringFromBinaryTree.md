LeetCode 606
====
[Construct String from Binary Tree](https://leetcode.com/problems/construct-string-from-binary-tree/)
----
# Problem
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

    Example 1:
    Input: Binary tree: [1,2,3,4]
          1
        /   \
       2     3
      /    
     4     
    Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".

    Example 2:
    Input: Binary tree: [1,2,3,null,4]
          1
        /   \
       2     3
        \  
         4 

    Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
# Solution
It is straight forward to solve this problem with divid-and-conqur. Basically there are 4 cases.

    Case 1:
    Node
    Print result: Node.val

    Case 2:
       Node
      /
    Subtree
    Print result: Node.val(recurse on Subtree)

    Case 3:
       Node
          \
          Subtree
    Print result: Node.val()(recurse on Subtree)

    Case 4:
           Node
        /        \
    Subtree1  Subtree2
    Print result: Node.val(recurse on Subtree1)(recurse on Subtree2)

Just simply translate these into code. We make the following helper function.

```java
    private StringBuilder createSubstringFromSubtree(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        if (node.left != null && node.right != null) {
            sb.append('(');
            sb.append(createSubstringFromSubtree(node.left));
            sb.append(')');
            sb.append('(');
            sb.append(createSubstringFromSubtree(node.right));
            sb.append(')');
        } else if (node.left != null) {
            sb.append('(');
            sb.append(createSubstringFromSubtree(node.left));
            sb.append(')');
        } else if (node.right != null) {
            sb.append("()(");
            sb.append(createSubstringFromSubtree(node.right));
            sb.append(')');
        }
        return sb;
    }
```
Some Java details:
* We use StringBuilder here because StringBuffer is thread-safe which uses more resources.
* We pass around StringBuilder around since internally a CharSequence.
* Some optimization can be made so that the code seems more compact. We intentionally didn't do that in favor of better readability.

We wrote a resursive solution here. It could be a conventional issue in terms of stack-over-flow. So instead we can write a interative solution.