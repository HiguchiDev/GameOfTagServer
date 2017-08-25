
import java.io.IOException;
import java.util.concurrent.Future;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Yucchi
 */
public class JavaFX3D_1 extends Application {

	private static WebSocketContainer container;
	private static Session session;
	static Group root = new Group();



    @Override
    public void start(Stage primaryStage) throws DeploymentException, IOException {

    	container = ContainerProvider
    			.getWebSocketContainer();
    	        // サーバー・エンドポイントの URI
    	//118.0.60.157
    	  /*      URI uri = URI
    	                .create("ws://192.168.10.104:8080/WebSocketInspect/loadMessage");
    	        //192.168.10.104
    	        System.out.print(container);
    	        // サーバー・エンドポイントとのセッションを確立する
    	        session = container.connectToServer(new WebSocketClientMain(primaryStage),
    	               uri);
*/


    	    	 Cylinder cylinder = new Cylinder(50.0d, 100.0d);

    	    	 Sphere sphere = new Sphere(50.0d);
    	    	 Scene scene = new Scene(root, 640.0d, 360.0d, Color.BLACK);
    	    		Box box = new Box(100.0d, 100.0d, 100.0d);
        // box を左へ (-200) 移動 (X 軸)
        box.setTranslateX(-200.0d);

        // cylinder を右へ (200) 移動 (X 軸) そして上へ (-100) 移動 (Y 軸)
        cylinder.setTranslateX(200.0d);
        cylinder.setTranslateY(-100.0d);

        // 透視投影カメラ
        final PerspectiveCamera cam = new PerspectiveCamera(true);
        // Field of View
        cam.setFieldOfView(45.5d);
        // Clipping Planes
        cam.setNearClip(1.0d);
        cam.setFarClip(1_000_000.0d);

        // カメラを 500 後退させる。(Z 軸を -500)
        cam.setTranslateZ(-500.0d);

        root.getChildren().addAll(box, cylinder, sphere);



        scene.setCamera(cam);

        scene.setOnKeyPressed(e ->{
        	try {
				connect();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
        });

        Timeline timer = new Timeline(new KeyFrame(Duration.millis(60), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            	/*try {
					connect();
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}*/
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

        
      /*  for (int i = 0; i < 10000; i++){
        	try {
				connect();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
        }
        */
        primaryStage.setTitle("JavaFX 3D 1");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


   	private void connect() throws Exception {

   		//System.err.println(session.isOpen());

   		Future future = session.getAsyncRemote().sendText("こんにちは");
   		/*try {
   		   future.get();
   		  } catch (InterruptedException e) {
   		   // TODO Auto-generated catch block
   		   e.printStackTrace();
   		  } catch (ExecutionException e) {
   		   // TODO Auto-generated catch block
   		   e.printStackTrace();
   		  }
*/


    }

}