//L.531 Lonely Pixel I
//O(mn) time O(min(m, n)) space
//idea comes from surfsession
class Solution {
    public int findLonelyPixel(char[][] picture) {
        int numRows = picture.length;
        int numCols = picture[0].length;
        int[] vline = new int[numRows]; // record total black pixels on each row
        
        for (int r = 0; r < numRows; r++) {
            int numBlk = 0;
            for (int c = 0; c < numCols && numBlk < 2; c++) {
                if (picture[r][c] == 'B')
                    numBlk++;
            }
            
            vline[r] = numBlk; // capped at 2
        }
                     
        int total = 0;
        
        for (int c = 0; c < numCols; c++) {
            int numBlk = 0;
            for (int r = 0; r < numRows && numBlk < 2; r++) {
                if (picture[r][c] == 'B')
                    numBlk += vline[r];
            }                
            if (numBlk == 1) {
                total++;
            }
        }             
        return total;
    }
}