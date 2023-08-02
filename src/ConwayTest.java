import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

//Telegram: @PieceJava
//Mohammad Reza AzimiFard
public class ConwayTest extends Application {
    private boolean play = true;
    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameBoard game = new GameBoard(600,600);
        game.render();
        KeyFrame kf = new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.render();
            }
        });
        Timeline t = new Timeline();
        t.getKeyFrames().add(kf);
        t.setCycleCount(Timeline.INDEFINITE);
        Scene scene = new Scene(game);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.SPACE){
                    if(play){
                        t.play();
                    }else{
                        t.stop();
                    }
                    play = !play;
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}