public class TestString {

    private final int LOOP_TIMES = 200000;
    private final String CONSTANT_STRING = "min-snail";

    public static void main(String[] args) {

        System.out.println(new TestString().getTrangle());
    }

    public void testString(){
        String string = "";
        long beginTime = System.currentTimeMillis();
        for(int i = 0; i < LOOP_TIMES; i++){
            string += CONSTANT_STRING;
        }
        long endTime = System.currentTimeMillis();
        System.out.print("String : " + (endTime - beginTime) + "\t");
    }

    public void testStringBuffer(){
        StringBuffer buffer = new StringBuffer();
        long beginTime = System.currentTimeMillis();
        for(int i = 0; i < LOOP_TIMES; i++){
            buffer.append(CONSTANT_STRING);
        }
        buffer.toString();
        long endTime = System.currentTimeMillis();
        System.out.print("StringBuffer : " + (endTime - beginTime) + "\t");
    }

    public void testStringBuilder(){
        StringBuilder builder = new StringBuilder();
        long beginTime = System.currentTimeMillis();
        for(int i = 0; i < LOOP_TIMES; i++){
            builder.append(CONSTANT_STRING);
        }
        builder.toString();
        long endTime = System.currentTimeMillis();
        System.out.print("StringBuilder : " + (endTime - beginTime) + "\t");
    }

    public int getTrangle(){

        int count = 0;
        for(int a=100;a<=999;a++){
            int i= a%10;
            int j = (a%100)/10;
            int k = a/100;
            System.out.println(k+" " + j + " " + i);
            if(i>0&&j>0&&k>0 &&i+j>k && i+k>j && k+j>i && Math.abs(i-j)<k && Math.abs(i-k)<j && Math.abs(j-k)<i){
                if(i==j || i==k || k==j){
                  count++;
                }
            }
        }
      return count;
    }

    public void startup(){
        for(int i = 0; i < 6; i++){
            System.out.print("The " + i + " [\t    ");
            testString();
            testStringBuffer();
            testStringBuilder();
            System.out.println("]");
        }
    }
}
