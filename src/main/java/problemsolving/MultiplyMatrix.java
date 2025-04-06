package problemsolving;

public class MultiplyMatrix {

    public static long[][] multiplyMatrix(long[][] m1 , long[][] m2) {
        
        long[][] res = new long[m1.length][m2[0].length];

        long nbrOfRowsMatrixM1 = m1.length; 
        long nbrOfColumnMatrixM1 = m1[0].length; 
        long nbrOfRowsMatrixM2 = m2.length;
        long nbrOfColumnsMatrixM2 = m2[0].length;

        if (nbrOfColumnMatrixM1 != nbrOfRowsMatrixM2)
            throw new RuntimeException("not of columns / rows not matching");

        for (int y = 0 ; y <=  nbrOfRowsMatrixM1- 1; y++) {
            for (  int x = 0 ; x <= nbrOfColumnsMatrixM2 - 1; x++) {
                for ( int c = 0 ; c <= nbrOfColumnMatrixM1 - 1 ; c++) {
                    res[y][x] = res[y][x] + m1[y][c] * m2[c][x];
                }
            }
        }

        return res; 
    }

}
