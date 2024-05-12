package pattern;

public class IncreasingNumberRightTriangle {
    public void triangle(){
        int number =1;
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(number++ +" ");
            }
            System.out.println();
        }
    }
}
