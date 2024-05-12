package pattern;

public class BasicTriangle {
    public void triangle(int rows){
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
}
