import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameBoard extends Pane implements EventHandler<MouseEvent> {
    private int width;
    private int height;
    private Conway game;
    private final int BLOCK_SIZE = 20;
    private Rectangle[][] cells;
    public GameBoard(int width,int height){
        this.width = width;
        this.height = height;
        int row = height/BLOCK_SIZE;
        int column = width/BLOCK_SIZE;
        this.game = new Conway(row,column);
        this.cells = new Rectangle[row][column];
        super.setPrefSize(width,height);
        super.setOnMouseClicked(this);
        super.setOnMouseDragged(this);
        createCell();

    }
    public void render(){
        for (int i = 0; i < this.game.row; i++) {
            for (int j = 0; j < this.game.column; j++) {
                if(this.game.board[i][j]==1){
                    this.cells[i][j].setFill(Color.BLACK);
                }else{
                    this.cells[i][j].setFill(Color.WHITE);
                    this.cells[i][j].setStroke(Color.GREY);
                }
            }
        }
        this.game.nextGeneration();
    }
    private void createCell(){
        for (int i = 0; i < this.game.row; i++) {
            for (int j = 0; j < this.game.column; j++) {
                int x = j * BLOCK_SIZE;
                int y = i * BLOCK_SIZE;
                cells[i][j]= new Rectangle(x,y,BLOCK_SIZE,BLOCK_SIZE);
                super.getChildren().add(cells[i][j]);
            }
        }
    }

    @Override
    public void handle(MouseEvent event) {
        double mouse_x = event.getX();
        double mouse_y = event.getY();
        for (int i = 0; i < this.game.row; i++) {
            for (int j = 0; j < this.game.column; j++) {
                if(mouse_x>cells[i][j].getX() && mouse_x<cells[i][j].getX()+BLOCK_SIZE &&
                mouse_y>cells[i][j].getY() && mouse_y<cells[i][j].getY()+BLOCK_SIZE){
                    cells[i][j].setFill(Color.BLACK);
                    this.game.board[i][j] = 1;
                }
            }
        }
    }
}

















