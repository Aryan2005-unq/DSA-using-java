class Solution{
    public int countComponents(int n,int[][] edges){
        int counter=0;
        List<Integer> adjList = new ArrayList[n];
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<edges.length;i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                counter++;
                dfs(visited,adjList,i);
            }
        }
        return counter;
    }
    public void dfs(int[] visited , List<Integer>[] adjList ,int node){
        visited[node]=1;
        for(int i=0;i<adjList[node].size();i++){
            if(visited[adjList[node].get(i)]==0){
                dfs(visited,adjList,adjList[node].get(i));
            }
        }
    }
}
