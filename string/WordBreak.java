package string;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String str, List<String> list){
        if(str.isEmpty())
            return true;
        for (String words : list){
            if(str.startsWith(words)){
                if(wordBreak(str.substring(words.length()),list))
                    return true;
            }
        }
        return false;
    }
}
