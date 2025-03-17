package dp;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostToConvertString {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long ans = 0;
        Map<Character, Map<Character, Long>> transformationCost = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            transformationCost.putIfAbsent(original[i], new HashMap<>());
            Map<Character, Long> targetMap = transformationCost.get(original[i]);

            targetMap.put(changed[i], Math.min(targetMap.getOrDefault(changed[i], Long.MAX_VALUE), cost[i]));
        }
        for (int i = 0; i < target.length(); i++) {
            char srcChar = source.charAt(i);
            char tgtChar = target.charAt(i);

            if (srcChar != tgtChar) {
                if (transformationCost.containsKey(srcChar) && transformationCost.get(srcChar).containsKey(tgtChar))
                    ans += transformationCost.get(srcChar).get(tgtChar);
                else
                    return -1;
            }
        }
        return ans;
    }
}
