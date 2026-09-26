class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        // Image is flipped
        for(int[] row: image){
            int i = 0;
            int j = row.length - 1;

            while(i < j){
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;

                i++;
                j--;
            }
        }

        // Values are inverted
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image.length; j++){
                image[i][j] = image[i][j] ^ 1;
            }
        }

        return image;
    }
}
