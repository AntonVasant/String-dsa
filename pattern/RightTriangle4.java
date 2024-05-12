package pattern;

public class RightTriangle4 {
    public void triangle(int row){
        for(int i=1;i<=row;i++){
            for(int j=row-i;j>=1;j--){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
