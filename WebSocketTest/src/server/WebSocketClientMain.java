package server;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import javafx.stage.Stage;

/**
 * Websocket Endpoint implementation class WebSocketClientMain
 */

@ClientEndpoint
public class WebSocketClientMain {
	Stage primaryStage;
	int count = 0;
	int limit = 100;
	boolean right = false;
	
    public WebSocketClientMain(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @OnOpen
    public void onOpen(Session session) {
        /* セッション確立時の処理 */
        System.err.println("[セッション確立]");
    }

    @OnMessage
    public void onMessage(String message) {
        /* メッセージ受信時の処理 */
    	//System.out.println(box.getTranslateX());
        //box.setTranslateX(box.getTranslateX() - 3);
    	count++;
    	
    	if (limit >= count){
    		count++;
    	}
    	else{
    		count = 0;
    		if(right){
    			right = false;
    		}
    		else{
    			right = true;
    		}
    	}
    	
		if(right){
			this.primaryStage.getScene().getCamera().setTranslateX(this.primaryStage.getScene().getCamera().getTranslateX() - 4);
		}
		else{
			this.primaryStage.getScene().getCamera().setTranslateX(this.primaryStage.getScene().getCamera().getTranslateX() + 4);
		}
		
    	
    	
    	System.err.println(this.primaryStage.getScene().getCamera().getTranslateX());
        
    	System.err.println("[受信bbbbbb]:" + message);
        
    }

    @OnError
    public void onError(Throwable th) {
        /* エラー発生時の処理 */
    }

    @OnClose
    public void onClose(Session session) {
        /* セッション解放時の処理 */
    }
/*
    public void connect() throws Exception {

    	WebSocketContainer container = ContainerProvider
		.getWebSocketContainer();
        // サーバー・エンドポイントの URI
        URI uri = URI
                .create("ws://192.168.10.104:8080/WebSocketInspect/loadMessage");

        System.out.print(container);
        // サーバー・エンドポイントとのセッションを確立する
        Session session = container.connectToServer(new WebSocketClientMain(),
               uri);

        session.getBasicRemote().sendText("こんにちは");

        while (session.isOpen()) {
            Thread.sleep(100 * 1000);
            System.err.println("open");
        }

    }
*/
}