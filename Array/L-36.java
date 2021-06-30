//L.36 Valid Sudoku
//O(1) time O(1) space
//Solution from amitverma1050@Leetcode
public boolean isValidSudoku(char[][] board) {
        return isValidSudoku_helper(board,0);
    }
    
     public boolean isValidSudoku_helper(char[][] board,int idx) {
        if(idx == 81) return true;
        
        int row = idx / 9;
        int col = idx % 9;
        if(board[row][col] != '.'){
            if(isSafePlaced(board,row,col,board[row][col]-'0')){
                    if(isValidSudoku_helper(board,idx+1)) return true;
                }
        }
        else{
            if(isValidSudoku_helper(board,idx+1)) return true;
        }
        
        return false;
    }
    
    public boolean isSafePlaced(char[][] board,int row,int col,int num){
        //row check
        for(int i=0;i<9;i++){
            if(i == row ) continue;
            if(board[i][col] - '0' == num) return false;
        }
        
        //column check
        for(int i=0;i<9;i++){
            if(i == col ) continue;
            if(board[row][i] - '0' == num) return false;
        }
        
        
        //board : 3 X 3 sub box check
        int subRow = (row / 3) * 3;
        int subCol = (col / 3) * 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(subRow + i == row && subCol + j == col) continue;
                if(board[subRow+i][subCol+j] - '0' == num) return false;
            }
        }
        
        return true;
    }