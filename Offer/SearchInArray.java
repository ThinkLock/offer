public class SearchInArray{
  private static boolean Find(int[][] array,int target){

      int rowlen = array.length;
      int clumlen = array[0].length;
      System.out.println(" " + rowlen + " " + clumlen);
      int i = rowlen-1;
      int j = 0;
      while(i>=0 && j<clumlen){
          if(target == array[i][j]){
            return true;
          }else if (target > array[i][j]) {
            j++;
          }else {
            i--;
          }
      }
      return false;
  }

  public static void main(String[] args) {
    int[][] array = { {1,2,3},
                      {2,5,7},
                      {4,7,19}};
    System.out.println("Hello World!" + Find(array,0));
  }
}
