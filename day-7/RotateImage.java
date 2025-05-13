class Solution {
    public void rotate(int[][] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }

        for(int row=0;row<arr.length;row++){
            int start=0;
            int end = arr.length-1;
            while(start<=end){
                int temp=arr[row][start];
                arr[row][start] = arr[row][end];
                arr[row][end] = temp;
                start++;
                end--;
            }
        }
    }
}