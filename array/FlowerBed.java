package array;

public class FlowerBed {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++){
            if (flowerbed[i] == 0){
                boolean left = (i == 0 || flowerbed[i-1] == 0);
                boolean right = (i == flowerbed.length-1 || flowerbed[i+1] == 0);
                if (left && right){
                    n--;
                    if (n == 0) return true;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }
}
