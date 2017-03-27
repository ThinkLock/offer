public class MoreThanHalfNum{

    public static int moreThanHalfNum(int[] array){
        int length = array.length;
        int morethanhalf = length/2 +1;
        for(int i=0;i<length;i++){
            int count = 1;
            for(int j=0;j<length;j++){
                if(i!=j && array[i]==array[j]){
                    count++;
                }
            }
            if(count>=morethanhalf){
                return array[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
          System.out.println(moreThanHalfNum(array));
    }
}
