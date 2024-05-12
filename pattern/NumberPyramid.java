package pattern;
/*   1
   121
  12321
 1234321
123454321
*/
public class NumberPyramid {
    public void  pyramid(){
     for(int i=1;i<=5;i++){
         for(int j=1;j<=5-i;j++){
             System.out.print(" ");
         }
         for(int k=1;k<=i;k++){
             System.out.print(k);
         }
         for(int l=i-1;l>=1;l--){
             System.out.print(l);
         }
         System.out.println();
     }
    }
}
