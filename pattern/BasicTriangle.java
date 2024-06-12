package pattern;

public class BasicTriangle {
    public static void triangle(int rows){
        int stars =1;
        for(int i=1;i<=rows;i++){
            for(int j=rows-i;j>=1;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=stars;k++){
                System.out.print("*");
            }
            stars+=2;
            System.out.println();
        }
    }

    public static void triangle2(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - i; j++)
                System.out.print(" ");
            for (int k = 1; k <= 2 * i + 1; k++)
                System.out.print(i + 1);
            System.out.println();
        }
    }
    public static void triangle3(int num){
        for (int i = 1; i <= num; i++){
            for (int j = 0; j < num - i; j++)
              System.out.print(" ");
            for (int k = 1; k <= i; k++)
                System.out.print(k);
            for (int l = i-1; l >=1; l--)
                System.out.print(l);
            System.out.println();
        }
    }
    public static void triangle4(int num){
        for (int i = 1; i <= num; i++){
            for (int j = 0; j < num-i;j++)
                System.out.print(" ");
            for (int k = i; k >= 1; k--)
                System.out.print(k);
            for (int l = 2; l <= i;l++)
                System.out.print(l);
            System.out.println();
        }
    }                                                   /*     1
                                                              212
                                                             32123
                                                            4321234
                                                           543212345
                                                          65432123456
                                                         7654321234567
                                                        876543212345678*/

    public static void triangle5(int num){
        for (int i = 0; i < num; i++){
            for(int j = 0; j <num; j++)
                System.out.print(" ");

        }
    }
}
