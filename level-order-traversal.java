//TC: O(n)
//SC: O(1)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //DFS
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode curr, int level, List<List<Integer>> result){
        //base
        if(curr == null) return;

        //logic
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(curr.val);
        dfs(curr.left, level+1, result);
        dfs(curr.right, level+1, result);

    }
}

//BFS
/* List<List<Integer>> result = new ArrayList<>();
if (root == null)
    return result;
Queue<TreeNode> q = new LinkedList<>();
q.add(root);
while (!q.isEmpty()) {
    int size = q.size();
    List<Integer> li = new ArrayList<>();
    for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        li.add(curr.val);
        if (curr.left != null) {
            q.add(curr.left);
        }
        if (curr.right != null) {
            q.add(curr.right);
        }
    }
    result.add(li);
}
return result;
}
} */