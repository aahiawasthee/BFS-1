//TC: O(V+E)
//SC: O(n)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // for dependency list
        int[] indegrees = new int[numCourses]; //how many pre requistes are there

        for (int[] edge : prerequisites) {
            int dep = edge[0];
            int in = edge[1];
            indegrees[dep]++;
            if (!map.containsKey(in)) {
                map.put(in, new ArrayList<>());
            }

            map.get(in).add(dep);
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                count++;
                if (count == numCourses)
                    return true;
            }
        }

        if (q.isEmpty())
            return false;

        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> babies = map.get(curr);
            if (babies != null) {
                for (int baby : babies) {
                    indegrees[baby]--;
                    if (indegrees[baby] == 0) {
                        q.add(baby);
                        count++;
                        if (count == numCourses)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}