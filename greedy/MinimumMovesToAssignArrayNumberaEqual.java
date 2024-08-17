package greedy;

public class MinimumMovesToAssignArrayNumberaEqual {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int n : machines)
            total += n;
        if (total % machines.length != 0) return -1;
        int target = total/ machines.length;
        int moves = 0;
        int cumulative = 0;
        for (int n : machines){
            int difference = target - n;
            cumulative += difference;
            moves = Math.max(moves,Math.max(Math.abs(cumulative),difference));
        }
        return moves;
    }

    /*
    Input: machines = [1,0,5]
Output: 3
Explanation:
1st move:    1     0 <-- 5    =>    1     1     4
2nd move:    1 <-- 1 <-- 4    =>    2     1     3
3rd move:    2     1 <-- 3    =>    2     2     2
     */
}
