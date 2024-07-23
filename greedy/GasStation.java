package greedy;

import java.util.Arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gases = Arrays.stream(gas).sum();
        int costs = Arrays.stream(cost).sum();
        if (gases < costs) return -1;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            if (total < 0){
                total = 0;
                start = i+1;
            }
        }
        return start;
    }
}
