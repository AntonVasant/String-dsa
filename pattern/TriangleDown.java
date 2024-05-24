package pattern;

public class TriangleDown {
    public static void triangle(int number){
        for (int i=0;i<number;i++){
            for (int j=0;j<=i;j++){
                System.out.print(" ");
            }
            for (int k=0;k<(number*2-i*2)-1;k++)
                System.out.print("*");
            System.out.println();
        }/*
          *********
           *******
            *****
             ***
              *
             */

    }
    public static void halfDiamond(int number){
        for (int i=0;i<number;i++){
            for (int j=0;j<=i;j++)
                System.out.print("*");
            System.out.println();
        }
        for (int k=0;k<=number;k++){
            for (int l=number-k;l>=0;l--)
                System.out.print("*");
            System.out.println();
        }
        /*
         *
         **
         ***
         ****
         *****
         ******
         *****
         ****
         ***
         **
         *
         */
    }
    public static void triangle01(int number){
        int start=1;
        for (int i=0;i<number;i++){
            if (i%2 == 0){
                start=1;
            }
            else start=0;
            for (int j =0;j<=i;j++){
                System.out.print(start+" ");
                start=1-start;
            }
            System.out.println();
        }
        /*
        1
        0 1
        1 0 1
        0 1 0 1
        1 0 1 0 1
        * */
    }
    public static void shape(int n){
        int space = 2*(n-1);
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j);
            }
            for (int k=0;k<space;k++)
                System.out.print(" ");
            for (int l = i;l>0;l--)
                System.out.print(l);
            System.out.println();
            space-=2;
        }
        /*

            1        1
            12      21
            123    321
            1234  4321
            1234554321
                     */
    }
    public static  void shapeFull(int num){
        for(int i=0;i<num;i++){
            for (int j = num;j>i;j--){
                System.out.print(j);
            }
            for (int k = 1;k<=i*2;k++)
                System.out.print(" ");
            for (int l = i+1;l<=num;l++)
                System.out.print(l);
            System.out.println();
        }
        int space = 2*(num-1);
        for (int i=1;i<=num;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int k = 0; k < space; k++)
                System.out.print(" ");
            for (int l = i; l > 0; l--)
                System.out.print(l);
            System.out.println();
            space -= 2;
        }
          /*5432112345
            5432  2345
            543    345
            54      45
            5        5
            1        1
            12      21
            123    321
            1234  4321
            1234554321*/
    }
}
