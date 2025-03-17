package rescursion;

import java.util.*;

public class ConcatenateWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String s : set) {
            Integer n = isValid(set, s);
            if (n != null && n != 1)
                list.add(s);
        }
        return list;
    }


    private Integer isValid(Set<String> set, String s) {
        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (set.contains(str)) {
                if (i == s.length())
                    return 1;
                else {
                    Integer depth = isValid(set, s.substring(i));
                    if (depth != null) return depth + 1;
                }
            }
        }
        return null;
    }
}
