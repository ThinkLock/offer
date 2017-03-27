public class HeapSort{

  public static void maxHeap(int[] a,int heapsize,int index){
      int left = 2*index;
      int right = 2*index + 1;

      int largest = 0;
      if(left<heapsize&& a[index]<a[left]){
        largest = left;
      }else{
			     largest = index;
		  }
      if(right<heapsize&& a[largest]<a[right]){
        largest = right;
      }
      if(largest!=index){
        int temp = a[ index ];
			  a[ index ] = a[ largest ];
			  a[ largest ] = temp;
        maxHeap(a,heapsize,largest);
      }else {
        return;
      }

  }

  public static void buildHeap(int[] a,int heapsize){

      for(int i=a.length/2;i>=1;--i){
          maxHeap(a,heapsize,i);
      }
  }

  public static void main(String[] args) {
      int[] a = {57, 68, 59, 52, 72, 28, 96, 33, 24};
      int min = a[0];
      		for(int i = 1 ; i < a.length ; i++ ){
      			if( min > a[i] ){
      				min = a[i];
      				a[i] = a[0];
      				a[0] = min;
      			}
      		}
      int heapSize = a.length;
  		buildHeap(a,heapSize);
  		for(int i = a.length - 1 ; i >= 2 ; i--){
  			int temp = a[1];
  			a[1] = a[i];
  			a[i] = temp;
  			heapSize--;
  			maxHeap(a,heapSize,1);
  		}
      for(int s : a){
        System.out.println(s);
      }
  }
}
