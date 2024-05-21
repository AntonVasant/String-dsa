package array;

public class CheckIfAInB {
    public boolean aInB(int a,int b){
        String first = String.valueOf(a);
        String second = String.valueOf(b);
        return first.contains(second);
    }
}
