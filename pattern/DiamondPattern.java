package pattern;

public class DiamondPattern {
    public void diamond(int number){
        int space = number/2;
        int stars=1;
        for(int i=1;i<=number;i++){
            for(int j=1;j<=space;j++){
                System.out.print(" ");
            }
            for (int k=1;k<=stars;k++){
                System.out.print("*");
            }
            System.out.println();
            if(i<=number/2){
                space--;
                stars+=2;
            }else {
                space++;
                stars-=2;
            }
        }
    }
}
