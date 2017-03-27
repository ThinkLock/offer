public class ReplaceSpace{
    public static String replaceSpace(StringBuffer str) {

        String s = str.toString().replaceAll(" ","%20");
        StringBuffer result = new StringBuffer(s);
        return result.toString();
    }

    public static void main(String[] args){
        StringBuffer s = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(s));
    }
}
