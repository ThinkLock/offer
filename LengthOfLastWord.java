public class LengthOfLastWord{

  public static int lengthofword(String s){

    String[] a = s.split(" ");

    for(String str : a){
      System.out.println(str);
    }

    if(a.length==0 || a.length==1){
      return 0;
    }else{
      return a[a.length-1].length();
    }
  }


  public static void main(String[] args) {
      String s = "Hello World";
      System.out.println(lengthofword(s));
  }
}
