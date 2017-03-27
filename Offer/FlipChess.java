public class FlipChess{

    //美团反转旗子
    public static int[][] flipChess(int[][] a,int[][] f){

        if(a==null || f==null || f.length==0 || a.length==0){
            return null;
        }

        int m = a.length;
        int n = a[0].length;

        for(int i=0;i<f.length;i++){
            int[] index = f[i];
            int x = index[0]-1;
            int y = index[1]-1;
            int x_left = x-1;
            int x_right = x+1;
            int y_left = y-1;
            int y_right = y+1;
            
            if(x_left>=0){
                a[x_left][y] = a[x_left][y]^1;
            }

            if(x_right<n){
                a[x_right][y] = a[x_right][y]^1;
            }     
             if(y_left>=0){
                a[x][y_left] = a[x][y_left]^1;
            }

            if(y_right<m){
                a[x][y_right] = a[x][y_right]^1;
            }     

        }
        
        int[][] result = a;
        return result;
    }



    public static void main(String[] args) {
        int[][] a = {{0,0,1,1},{1,0,1,0},{0,1,1,0},{0,0,1,0}};
        int[][] f = {{2,2},{3,3},{4,4}};
        ArrayUtils.print2Array(a);
        int[][] b = flipChess(a,f);
        ArrayUtils.print2Array(b);
    }
}