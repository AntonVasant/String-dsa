package string;

public class ValidateIP {
    public static boolean isValid(String s) {
        String[] array = s.split("\\.");
        System.out.println();
        if(array.length != 4) return false;
        for(String str : array){
            System.out.println(str);
            if(!isCorrect(str)){
                return false;
            }
        }
        return true;
    }


    private static boolean isCorrect(String s){
        if(s.length() > 0 && s.charAt(0) == '0') return false;
        try{
            int n = Integer.parseInt(s);
            return n >= 0 && n <= 255;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
