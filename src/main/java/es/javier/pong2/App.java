package es.javier.pong2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    int ballCenterX = 450;
    int ballCurrentSpeedX = 3;
    int ballDirectionX = 1 ;
    int ballCenterY = 450;
    int ballCurrentSpeedY = 3;
    int ballDirectionY = 1 ;
    @Override
    public void start(Stage stage) { 
    //escena o ventana 
        Pane root = new Pane();
        var scene = new Scene(root, 640, 480);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
        
        //New Circle() , crear un objeto de la clase Circle
        Circle circleBall = new Circle();
        //Llamando a metodos del objeto circleBall
        circleBall.setCenterX(10);
        circleBall.setCenterY(30);
        circleBall.setRadius(7);
        circleBall.setFill(Color.WHITE);
        
        //Circle circleBall2 = new Circle(10,30,7);
        
        root.getChildren().add(circleBall);
        
        Timeline timeline = new Timeline(
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    circleBall.setCenterX(ballCenterX);
                    ballCenterX+=ballCurrentSpeedX * ballDirectionX;
                    if(ballCenterX >= 640){
                        ballCurrentSpeedX = -3;
                    }else if (ballCenterX <= 0){
                        ballCurrentSpeedX = 3;
                    
                    }
                    circleBall.setCenterY(ballCenterX);
                    ballCenterY+=ballCurrentSpeedY * ballDirectionY;
                    if(ballCenterY >= 640){
                        ballCurrentSpeedY = -3;
                    }else if (ballCenterY <= 0){
                        ballCurrentSpeedY = 3;
                }
                }
                  
            })                
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();     
    }
    
    

    public static void main(String[] args) {
        launch();
    }

}