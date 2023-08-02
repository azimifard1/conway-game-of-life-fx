import java.util.Random;

//Telegram: @PieceJava
//Mohammad Reza AzimiFard
public class Conway {
    int[][] board;
    int row,column;
    public Conway(int row,int column){
        this.board = new int[row][column];
        this.row = row;
        this.column = column;
    }
    public void randomInitialize(){
        Random r = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.board[i][j] = r.nextInt(2);
            }
        }
    }
    public void nextGeneration(){
        int[][] nextG = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //rules
                int neighbors = countNeighbors(i,j);
                if(board[i][j]==1){
                    //rule 1
                    if(neighbors<2){
                        nextG[i][j] = 0;
                    }
                    //rule 2
                    else if(neighbors>3){
                        nextG[i][j] = 0;
                    }
                    //rule 3
                    else{
                        nextG[i][j] = board[i][j];
                    }
                }else{
                    //rule 4
                    if(neighbors==3){
                        nextG[i][j] = 1;
                    }
                }
            }
        }
        this.board = nextG;
    }
    public void printBoard(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(board[i][j]==1){
                    System.out.print(board[i][j]+" ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private int countNeighbors(int i, int j) {
        int neighbors = 0;
//        neighbors+=board[i-1][j-1];
//        neighbors+=board[i-1][j];
//        neighbors+=board[i-1][j+1];
//
//        neighbors+=board[i][j-1];
//        neighbors+=board[i][j];
//        neighbors+=board[i][j+1];
//
//        neighbors+=board[i+1][j+1];
//        neighbors+=board[i+1][j];
//        neighbors+=board[i+1][j-1];
        for (int k = -1; k <=1 ; k++) {
            for (int l = -1; l <= 1; l++) {
                if((i+k>=0 && i+k<row) && (j+l>=0 && j+l<column))
                    neighbors+=board[i+k][j+l];
            }
        }
        neighbors-=board[i][j];
        return neighbors;

    }
}
