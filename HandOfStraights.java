class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer,Integer> cards = new TreeMap<>();
        for(int Hand : hand){
            cards.put(Hand,cards.getOrDefault(Hand,0)+1);
        }
        while(!cards.isEmpty()){
            int currentHand = cards.firstKey();
            for(int i=0;i<groupSize;i++){
                int current = currentHand+i;
                if(!cards.containsKey(current)){
                    return false;
                }
                if(cards.get(current)==1){
                    cards.remove(current);
                }else{
                    cards.put(current,cards.get(current)-1);
                }
            }
        }
        return true;
    }
}   Hand
