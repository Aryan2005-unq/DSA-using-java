class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> graph = new HashMap<>();

        for(int[] time : times){
            graph.computeIfAbsent(time[0],m-> new ArrayList<>()).add(new int[]{time[1],time[2]});
        }
        PriorityQueue<int[]> priority = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        priority.offer(new int[]{k,0});
        int[] Distances = new int[n+1];
        Arrays.fill(Distances,Integer.MAX_VALUE);
        Distances[k] = 0;
        while(!priority.isEmpty()){
            int[] distance = priority.poll();
            int currentNode = distance[0];
            int currentDistance = distance[1];

            if(currentDistance > Distances[currentNode]){
                    continue;
            }
            if(graph.containsKey(currentNode)){
                for(int[] neighbour : graph.get(currentNode)){
                    int nextNode = neighbour[0];
                    int nextDistance = currentDistance + neighbour[1];
                    
                    if(nextDistance < Distances[nextNode]){
                        Distances[nextNode] = nextDistance;
                        priority.offer(new int[]{nextNode,nextDistance});
                    }
                }
            }
        }
        int minTime = Arrays.stream(Distances).skip(1).max().getAsInt();
        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }
}
