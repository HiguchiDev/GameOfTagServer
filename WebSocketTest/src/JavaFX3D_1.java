
import java.io.IOException;

import javax.websocket.DeploymentException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Yucchi
 */
public class JavaFX3D_1 extends Application {

	@Override
	public void start(Stage primaryStage) throws DeploymentException, IOException {
		Group root = new Group();
		Sphere sphere = new Sphere(50.0d);
		Scene scene = new Scene(root, 640.0d, 360.0d, Color.BLACK);
		;
		// 透視投影カメラ
		final PerspectiveCamera cam = new PerspectiveCamera(true);
		// Field of View
		cam.setFieldOfView(45.5d);
		cam.setNearClip(1.0d);
		cam.setFarClip(1_000_000.0d);

		// カメラを 500 後退させる。(Z 軸を -500)
		cam.setTranslateZ(-500.0d);

		root.getChildren().addAll(sphere);

		scene.setCamera(cam);
		scene.setOnKeyPressed(e -> {

		});

		scene.setOnKeyPressed(e -> {
			try {

			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		});

		Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();

		primaryStage.setTitle("JavaFX 3D 1");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}