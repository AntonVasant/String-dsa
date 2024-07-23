package graph;

import java.util.*;

public class FreedomTrail {
        public int findRotateSteps(String ring, String key) {
            int rLen = ring.length();
            int kLen = key.length();

            // Build the map to store all positions of each character in the ring
            Map<Character, List<Integer>> charToIndices = new HashMap<>();
            for (int i = 0; i < rLen; i++) {
                charToIndices.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
            }

            // Queue for BFS (each element is a state represented by [ring position, key index, steps])
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0, 0});

            // Set to track visited states
            Set<String> visited = new HashSet<>();
            visited.add(0 + "-" + 0);

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int ringPos = current[0];
                int keyIndex = current[1];
                int steps = current[2];

                // If we have spelled the entire key
                if (keyIndex == kLen) {
                    return steps;
                }

                // Get the character we need to match in the key
                char c = key.charAt(keyIndex);

                // Iterate over all positions of the current character in the ring
                for (int newPos : charToIndices.get(c)) {
                    int distance = getDistance(ringPos, newPos, rLen);
                    int newSteps = steps + distance + 1; // +1 for pressing the button

                    // Form the new state
                    String newState = newPos + "-" + (keyIndex + 1);

                    // If the state has not been visited, add it to the queue
                    if (!visited.contains(newState)) {
                        visited.add(newState);
                        queue.offer(new int[]{newPos, keyIndex + 1, newSteps});
                    }
                }
            }

            return -1; // In case something goes wrong, though this shouldn't happen
        }

        private int getDistance(int from, int to, int len) {
            return Math.min(Math.abs(from - to), len - Math.abs(from - to));
        }
    }
