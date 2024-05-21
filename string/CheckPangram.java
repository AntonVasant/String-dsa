package string;

public class CheckPangram {
    public boolean pangram(String str){
        boolean[] letters = new boolean[26];
        for (char c : str.toCharArray()){
            if(Character.isLetter(c)){
                char ch = Character.toLowerCase(c);
                letters[ch-'a']=true;
            }
        }
        for(boolean letter : letters){
            if(!letter)
                return false;
        }
        return true;
    }
}
