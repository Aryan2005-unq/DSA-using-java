class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        Map<String,List<String>> allComboDict = new HashMap<>();
        wordList.forEach(word ->{
            for(int i=0;i<L;i++){
                String newWord = word.substring(0,i) + '*' + word.substring(i+1,L);

                List<String> transformation = allComboDict.getOrDefault(newWord,
                new ArrayList<>());
                transformation.add(word);
                allComboDict.put(newWord,transformation);
            }
        });
        HashMap<String,Boolean> visited = new HashMap<>();
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        visited.put(beginWord,true);
        queue.add(new Pair(beginWord,1));

        while(!queue.isEmpty()){
            Pair<String,Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for(int i=0;i<L;i++){
                String newWord = word.substring(0,i) + '*' + word.substring(i+1,L);

                for(String adjacent : allComboDict.getOrDefault(newWord,new ArrayList<>())){
                    if(adjacent.equals(endWord)){
                        return level+1;
                    }
                    if(!visited.containsKey(adjacent)){
                        visited.put(adjacent,true);
                        queue.add(new Pair(adjacent,level+1));
                    }
                }
            }
        }
        return 0;
    }
}
