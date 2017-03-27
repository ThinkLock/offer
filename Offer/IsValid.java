import java.util.Stack;

public class IsValid{

  public static boolean isValid(String s) {
      if(s.length()==0)
        return false;
      if(s.length()%2!=0)
        return false;
      char[] strs = s.toCharArray();
      Stack stack = new Stack();
      for(int i=0;i<s.length();i++){
        char item = strs[i];
        if(item=='(' || item=='[' || item=='{'){
            stack.push(item);
        }else if(item=='(' || item=='[' || item=='{'){
            char top = stack.peek().toString().charAt(0);
            if(top==item){
              stack.pop();
            }else {
              return false;
            }
        }else {
          return false;
        }
      }

      if(!stack.empty()){
          return false;
      }
      return true;
  }
  public static void main(String[] args){

      String strs = "{{}}";
      System.out.println(isValid(strs));
  }
}
