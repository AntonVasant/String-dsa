package matrix;

public class SnakeTraversalTop {
    public void snakeTop(int[][] array){
        int num=array.length;
        for(int i=0;i<num;i++){
            if(i%2==0){
                for(int j=0;j<num;j++){
                    System.out.println(array[i][j]+" ");
                }
            }else {
                for (int k=num-1;k>=0;k--){
                    System.out.println(array[i][k]+" ");
                }
            }
        }
    }
}
