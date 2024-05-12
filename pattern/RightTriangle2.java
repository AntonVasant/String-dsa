package pattern;

public class RightTriangle2 {
    public void triangle(int rows){
        for(int i=0;i<=rows;i++){
            for(int j=rows-i;j>=1;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
