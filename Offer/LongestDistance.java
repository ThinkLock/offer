import java.util.*;
public class LongestDistance{
    //美团最大差值
    public static int longestDistance(int[] A,int n){
        if(A==null || A.length==0 || A.length==1 || A.length==2){
            return 0;
        }

        int max = 0;
        for(int a=0;a<n;a++){
            for(int b=a;b<n;b++){
                if(A[b]-A[a]>max){
                    max = A[b]-A[a];
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}