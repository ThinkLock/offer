public class FindGreatestSumOfSubArray{

    //枚举出所有的数组的子数组，然后找到最大和
    public static int findGreatestSumOfSubArray(int[] array){
      int len = array.length;

      int maxsum = 0;
      for(int i=0;i<len;i++){
          int sum = 0;
          for(int j=i;j<len;j++){
              sum = sum+array[j];
              if(sum>maxsum){
                  maxsum = sum;
              }
          }
      }

      return maxsum;
    }


    public static int findGreatestSumOfSubArray2(int[] array){
        if(array==null||array.length==0){
          return 0;
        }

        int len = array.length;

        int c_sum = 0;
        int max_sum = 0;

        for(int i=0;i<len;i++){
            if(c_sum<0){
              c_sum=array[i];
            }else{
              c_sum+=array[i];
            }

            if(max_sum<c_sum){
              max_sum = c_sum;
            }
        }
        return max_sum;

    }

    public static void main(String[] args) {

      int[] a = {1,-2,3,10,-4,7,2,-5};//,9,54,23,55,-100,4,6,78};
      System.out.println(findGreatestSumOfSubArray2(a));
    }
}
