import java.util.*;
class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                root = i;
            } 
            else {
                adj[parent[i]].add(i);
            }
        }
        int height = findHeight(root, adj);
        return dfs(root, 1, height, adj, nums);
    }
    private static int findHeight(int node, List<Integer>[] adj) {
        int maxHeight = 0;
        for (int child : adj[node]) {
            maxHeight = Math.max(maxHeight, findHeight(child, adj));
        }
        return maxHeight + 1;
    }
    private static long dfs(int node, int depth, int height, List<Integer>[] adj, int[] nums){
        long weight = (long) nums[node] * (height - depth + 1);
        for (int child : adj[node]) {
            weight += dfs(child, depth + 1, height, adj, nums);
        }
        return weight;
    }
}
