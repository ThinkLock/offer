public class StrStr{

    public static int strStr(String a,String b){
        int lena = a.length();
        int lenb = b.length();

        int i=0;
        while(i<lena-lenb){
            if(a.substring(i,lenb+i).equals(b)){
                return i;
            }else {
              i++;
            }
        }
        return -1;
    }



    public static String Main(String s){
        char[] a = s.toCharArray();
        if(s.length()==0)
            return "";
        if(s.length()==1)
            return s;
        int len = s.length();
        int numoflow = 0;
        int k=len;
        for(int i=len-1;i>=0;i--){
            if(a[i]>='A'&&a[i]<='Z'){
                char tmp = a[i];
                int j=i;
                k--;
                while(j<k){
                    a[j] = a[j+1];
                    j++;
                }
                a[j] = tmp;
            }
        }


        return String.valueOf(a);
    }


    public static void main(String[] args) {

        System.out.println(Main("AkleBiCeilD"));
    }

}
