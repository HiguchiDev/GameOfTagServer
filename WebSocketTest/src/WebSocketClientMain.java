import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 * Websocket Endpoint implementation class WebSocketClientMain
 */

@ClientEndpoint
public class WebSocketClientMain {

    public WebSocketClientMain() {
        super();
    }

    @OnOpen
    public void onOpen(Session session) {
        /* セッション確立時の処理 */
        System.err.println("[セッション確立]");
    }

    @OnMessage
    public void onMessage(String message) {
        /* メッセージ受信時の処理 */
        System.err.println("[受信]:" + message);
    }

    @OnError
    public void onError(Throwable th) {
        /* エラー発生時の処理 */
    }

    @OnClose
    public void onClose(Session session) {
        /* セッション解放時の処理 */
    }

    static public void main(String[] args) throws Exception {

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

}