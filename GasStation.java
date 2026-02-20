class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int maxGas = 0;
        int maxCost = 0;
        int tank = 0;
        int startIndex = 0;
        for(int i=0;i<gas.length;i++){
            maxGas += gas[i];
            maxCost += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                startIndex = i+1;
                tank = 0;
            }
        }
        if(maxGas < maxCost) return -1;
        return startIndex;
    }
}
