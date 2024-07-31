package matrix;

public class RotateImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] arr : image)
            reverse(arr);
        int r = image.length;
        int c = image[0].length;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                image[i][j] = image[i][j] == 1 ? 0 : 1;
            }
        }
        return image;
    }

    private void reverse(int[] arr){
        int low = 0;
        int high = arr.length-1;
        while (low < high){
            int te = arr[low];
            arr[low] = arr[high];
            arr[high] = te;
            low++;
            high--;
        }
    }
}
