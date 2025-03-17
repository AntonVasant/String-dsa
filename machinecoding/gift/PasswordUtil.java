package machinecoding.gift;

public class PasswordUtil {

    public static String encryptPassword(String password){
        StringBuilder builder = new StringBuilder();
        for (char c : password.toCharArray()){
            if (Character.isDigit(c)){
                builder.append((c - '0' + 1) % 10);
            }
            else {
                builder.append((c - 'a' + 1) % 26);
            }
        }
        return builder.toString();
    }

    public static boolean verifyPassword(String password, String hash){
        String hashed = encryptPassword(password);
        return hashed.equals(hash);
    }


}
