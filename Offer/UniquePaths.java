public class UniquePaths{

  public static int uniquePaths(int m, int n) {
        if(m==0 || n==0)return 0;
        int[][] a = new int[m][n];
        a[0][0] = 0;
        for(int i=1;i<m;i++){
            a[i][0]=1;
        }

        for(int j=1;j<n;j++){
            a[0][j] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                a[i][j] = a[i-1][j] + a[i][j-1];
            }
        }

        return a[m-1][n-1];
  }
  public static void main(String[] args) {

      System.out.println(uniquePaths(3,5));
  }
}
