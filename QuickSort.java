public class QuickSort{

  public static void qsort(int[] a,int low,int high){
    if(low<high){
        int pivot = partition(a,low,high);
        qsort(a,low,pivot-1);
        qsort(a,pivot+1,high);
    }
  }

  public static int partition(int[] a,int low,int high){
      int pivot = a[low];
      while(low<high){
        while(low<high&&a[high]>=pivot) --high;
        a[low]= a[high];
        while(low<high&& a[low]<=pivot) ++low;
        a[high] = a[low];
      }
      a[low]=pivot;
      return low;
  }

  public static void main(String[] args) {
    int[] a = {57, 68, 59, 52, 72, 28, 96, 33, 24};
    qsort(a,0,a.length-1);
    for(int s : a){
      System.out.println(s);
    }
  }
}
