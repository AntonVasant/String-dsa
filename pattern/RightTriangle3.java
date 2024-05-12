package pattern;

public class RightTriangle3 {
    public void triangle(int row){
        for(int i=0;i<=row;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int k=row-i;k>=1;k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
