public class LongestCommonPrefix{

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){return "";}
        if(strs.length==1){return strs[0];}


        String commen = strs[0];
        for(int i=0;i<strs.length;i++){
          while(strs[i].indexOf(commen) != 0)
              commen = commen.substring(0,commen.length()-1);
        }
        return commen;
    }

    public static void main(String[] args){

        String[] strs = {"abc","ab","abbb","abcd"};
        System.out.println(longestCommonPrefix(strs));
    }
}
