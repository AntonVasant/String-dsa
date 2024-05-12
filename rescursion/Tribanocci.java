package rescursion;

public class Tribanocci {
    public int tri(int n){
        if(n==0)
            return 0;
        else if(n==1|n==2)
            return 1;
        else return tri(n-1)+tri(n-2)+tri(n-3);
    }
}
