class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       HashMap<Integer,List<Integer>> connections = new HashMap<>();
       for(int[] pre : prerequisites){
        if(connections.containsKey(pre[1])){
            connections.get(pre[1]).add(pre[0]);
        }else{
            List<Integer> courses = new LinkedList<>();
            courses.add(pre[0]);
            connections.put(pre[1],courses);
        }
       } 
       HashSet<Integer> visited = new HashSet<>();
       for(int i=0;i<numCourses;i++){
        if(courseSchedule(i,connections,visited)==false){
            return false;
        }
       }
       return true;
    }
    public boolean courseSchedule(int course,HashMap<Integer,List<Integer>> connections,HashSet<Integer> visited){
        if(visited.contains(course)){
            return false;
        }
        if(connections.get(course)==null){
            return true;
        }
        visited.add(course);
        for(int pre : connections.get(course)){
            if(courseSchedule(pre,connections,visited)==false){
                return false;
            }
        }
        visited.remove(course);
        connections.put(course,null);
        return true;
    }
}
