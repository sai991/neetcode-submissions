

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Map each course to its prerequisite list (preMap)
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            preMap.get(p[0]).add(p[1]);
        }

        // Tracks courses along the current DFS path (visitSet)
        Set<Integer> visitSet = new HashSet<>();

        // Helper DFS function
        for (int crs = 0; crs < numCourses; crs++) {
            if (!dfs(crs, preMap, visitSet)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int crs, Map<Integer, List<Integer>> preMap, Set<Integer> visitSet) {
        // Cycle detected
        if (visitSet.contains(crs)) {
            return false;
        }
        // Course has no prerequisites (already verified as solvable)
        if (preMap.get(crs).isEmpty()) {
            return true;
        }

        visitSet.add(crs);
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre, preMap, visitSet)) {
                return false;
            }
        }
        visitSet.remove(crs);

        // Optimization: empty the preMap entry so we don't repeat DFS for this course
        preMap.get(crs).clear();
        return true;
    }
}