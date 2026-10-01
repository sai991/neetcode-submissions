

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: A valid tree MUST have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        // Start DFS from node 0 with dummy parent -1
        dfs(0, -1, adj, visited);

        // Condition 2: Graph must be fully connected (all 'n' nodes visited)
        return visited.size() == n;
    }

    private void dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> visited) {
        visited.add(node);

        for (int neighbor : adj.get(node)) {
            // Skip the back-edge to the parent node we came from
            if (neighbor == parent) {
                continue;
            }

            // Recursively visit unexplored neighbors
            if (!visited.contains(neighbor)) {
                dfs(neighbor, node, adj, visited);
            }
        }
    }
}