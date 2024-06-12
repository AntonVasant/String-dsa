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
    public static void diamondNumber(int number){
        for (int i = 0; i <= number; i++){
            for (int j = 0;j <= number - i; j++)
                System.out.print(" ");
            for (int k = 1; k <= i+1; k++)
                System.out.print(k);
            for (int l = i; l >=1; l--)
                System.out.print(l);
            System.out.println();
        }
        for (int i = 0; i < number; i++){
            for (int j = 0; j <= i+1;j++)
                System.out.print(" ");
            for (int k = 1; k < number-i; k++)
                System.out.print(k);
            for (int l = number - i; l >= 1;l--)
                System.out.print(l);
            System.out.println();
        }
    }
}
