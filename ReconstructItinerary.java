class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from,k -> new ArrayList<String>()).add(to);
        }
        for(List<String> destination : graph.values()){
            Collections.sort(destination);
        }

        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK",itinerary,graph);
        return itinerary;
    }
    private static void dfs(String airport, LinkedList<String> itinerary, Map<String,List<String>> graph){
        List<String> destination = graph.get(airport);
        while(destination!=null && !destination.isEmpty()){
            String next = destination.remove(0);
            dfs(next,itinerary,graph);
        }
        itinerary.addFirst(airport);
    }
}
