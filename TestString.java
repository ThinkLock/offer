public class TestString {

    private final int LOOP_TIMES = 200000;
    private final String CONSTANT_STRING = "min-snail";

    public static void main(String[] args) {

        new TestString().startup();
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
