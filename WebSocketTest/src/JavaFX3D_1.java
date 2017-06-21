
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 *
 * @author Yucchi
 */
public class JavaFX3D_1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        final Group root = new Group();
        
        final Box box = new Box(100.0d, 100.0d, 100.0d);
        
        final Cylinder cylinder = new Cylinder(50.0d, 100.0d);
        
        final Sphere sphere = new Sphere(50.0d);
        
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
        
        Scene scene = new Scene(root, 640.0d, 360.0d, Color.BLACK);
        
        scene.setCamera(cam);
        
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
    
}