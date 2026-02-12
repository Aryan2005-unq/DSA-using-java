class Solution {
    Map<Character,List<Character>> reversedList = new HashMap<>();
    Map<Character,Boolean> seen = new HashMap<>();
    public StringBuilder result = new StringBuilder();
    public String foreignDictionary(String[] words) {
      for(String word : words){
        for(Character c : word.toCharArray()){
            reversedList.putIfAbsent(c,new ArrayList<>());
        }
      }
      for(int i=0;i<words.length-1;i++){
        String word1 = words[i];
        String word2 = words[i+1];
        if(word1.length()>word2.length() && word1.startsWith(word2)){
            return "";
        }

        for(int j=0;j<Math.min(word1.length(),word2.length());j++){
            if(word1.charAt(j)!=word2.charAt(j)){
                reversedList.get(word2.charAt(j)).add(word1.charAt(j));
                break;
            }
        }
      }
      for(Character c : reversedList.keySet()){
        boolean res = dfs(c);
        if(!res) return "";
      }
      if(result.length() < reversedList.size()){
        return "";
      }
      return result.toString();
    }
    public boolean dfs(char ch){
        if(seen.containsKey(ch)){
            return seen.get(ch);
        }
        seen.put(ch,false);
        for(Character next:reversedList.get(ch)){
            boolean res = dfs(next);
            if(!res) return false;
        }
        seen.put(ch,true);
        result.append(ch);
        return true;
    }
}
