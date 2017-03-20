import java.util.*;
public class ThreeChess{
    
    public static boolean isWin(char[][] a,char flag){

        List<String> allLine = new ArrayList<>();
        
        for(int i=0;i<a.length;i++){
            StringBuffer sb1 = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            for(int j=0;j<a.length;j++){
                sb1.append(a[i][j]);
                sb2.append(a[j][i]);
            }
            allLine.add(sb1.toString());
            allLine.add(sb2.toString());
        }

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        sb1.append(a[0][0]);
        sb2.append(a[2][0]);
        sb1.append(a[1][1]);
        sb2.append(a[1][1]);
        sb1.append(a[2][2]);
        sb2.append(a[0][2]);

        allLine.add(sb1.toString());
        allLine.add(sb2.toString());

        String temp = "xxx";
        if(flag=='x'){
            temp = "xxx";
        }else{
             temp = "ooo";
        }

        for(String s : allLine){
            if(s.equals(temp)){
                return true;
            }
        }

        return false;
    }
     
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] a = new char[3][3];
        for(int i=0;i<3;i++){
            a[i] = sc.next().toCharArray();
        }
        ArrayUtils.print2Array(a); 

        int x_count = 0;
        int o_count = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(a[i][j]=='x'){
                    x_count++;
                }else if(a[i][j]=='o'){
                    o_count++;
                }
            }
        }

        if(x_count+o_count==9){
            //判断是不是先手赢了 或者平局
            if(Math.abs(x_count-o_count)==1){
                if(x_count>o_count){
                    if(isWin(a, 'x')){
                        System.out.println("1 won");
                    }else{
                        System.out.println("draw");
                    }
                }else{
                    if(isWin(a, 'o')){
                        System.out.println("1 won");
                    }else{
                        System.out.println("draw");
                    }
                }
            }else{
                System.out.println("x");
            }
        }else if(x_count+o_count==0){
            System.out.println("1");
        }else if(x_count==o_count){
            if(isWin(a, 'o') || isWin(a, 'x')){
                 System.out.println("2 won");
            }else{
                 System.out.println("1");
            }
        }else if(Math.abs(x_count-o_count)==1){
            if(isWin(a, 'o') || isWin(a, 'x')){
                 System.out.println("1 won");
            }else{
                 System.out.println("2");
            }
        }else{
            System.out.println("x");
        }
    }
}