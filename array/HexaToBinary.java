package array;

public class HexaToBinary {
    public String hexToBinary(String str){
        int num = Integer.parseInt(str,16);
        String result = Integer.toBinaryString(num);
        return result;
    }
}
