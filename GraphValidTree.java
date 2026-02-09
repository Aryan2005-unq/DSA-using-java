class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        stack.push(0);
        visited.add(0);
        while(!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbour : adjList.get(node)){
                if(visited.contains(neighbour)){
                    continue;
                }
                visited.add(neighbour);
                stack.push(neighbour);
            }
        }
        return visited.size()==n ? true : false;

    }
}
