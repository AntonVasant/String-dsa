package string;

public class ZigZag {
    public static void pattern(String s,int row){
        StringBuilder[] sb = new StringBuilder[row];
        for (int i = 0; i < row; i++)
            sb[i] = new StringBuilder();
        int currentRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()){
            if (currentRow == 0 || currentRow == row-1){
                sb[currentRow].append(c+"  ");
                goingDown = !goingDown;
            }else sb[currentRow].append(c+" ");
            currentRow += goingDown ? 1 : -1;
        }
        for (StringBuilder str : sb){
            System.out.println(str);
            System.out.println();
        }

    }
}
