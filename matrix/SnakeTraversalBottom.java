package matrix;

public class SnakeTraversalBottom {
    public void snakeBottom(int[][] array){
        int num= array.length;;
        for(int i=num-1;i>=0;i--){
            if(i%2==0){
                for (int j=num-1;j>=0;j--){
                    System.out.println(array[i][j]+" ");
                }
            }else {
                for (int k=0;k<num;k++){
                    System.out.println(array[i][k]+" ");
                }
            }
        }
    }
}
