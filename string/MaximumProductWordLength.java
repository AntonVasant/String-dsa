package string;

    public class MaximumProductWordLength{
        public int maxProduct(String[] words) {
            int n = words.length;
            int[] bitMasks = new int[n];
            int[] lengths = new int[n];

            // Step 1: Compute bitmasks for each word
            for (int i = 0; i < n; i++) {
                bitMasks[i] = getBitMask(words[i]);
                lengths[i] = words[i].length();
            }

            int maxProduct = 0;

            // Step 2: Compare all pairs of words
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((bitMasks[i] & bitMasks[j]) == 0) { // No common letters
                        maxProduct = Math.max(maxProduct, lengths[i] * lengths[j]);
                    }
                }
            }

            return maxProduct;
        }

        // Helper method to compute bitmask for a word
        private int getBitMask(String word) {
            int bitMask = 0;
            for (char c : word.toCharArray()) {
                bitMask |= 1 << (c - 'a');
            }
            return bitMask;
        }

        public static void main(String[] args) {
            MaximumProductWordLength solution = new MaximumProductWordLength();

            String[] words1 = {"abc", "def", "ghi"};
            System.out.println(solution.maxProduct(words1)); // Output: 9 (length of "abc" * length of "def")

            String[] words2 = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
            System.out.println(solution.maxProduct(words2)); // Output: 16 (length of "abcd" * length of "ef")
        }
    }
    
