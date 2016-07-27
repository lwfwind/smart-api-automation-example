package test.java;

import com.qa.framework.mock.IMockServer;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.*;
import java.util.concurrent.TimeUnit;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;


public class MockServer implements IMockServer {

    private ClientAndServer mockServer;

    public void startServer() {
        mockServer = startClientAndServer(1081);
    }

    public void settingRules() {
        mockServer
                .when(
                        new HttpRequest()
                                .withMethod("POST")
                                .withPath("/login")
                                .withBody("username=13636426195&password=bddeaa7037632c856a6b83e4037f314a")
                )
                .respond(
                        new HttpResponse()
                                .withStatusCode(200)
                                .withHeaders(
                                        new Header("Content-Type", "application/json; charset=utf-8"),
                                        new Header("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0"),
                                        new Header("Set-Cookie", "PHPSESSID=9alb81bkiav0nffo0r8m9vf5s3; path=/")
                                )
                                .withBody("{errorCode:200,errorMsg:\"登录成功\"}")
                                .withDelay(TimeUnit.MILLISECONDS, 100)
                );
        mockServer
                .when(
                        new HttpRequest()
                                .withMethod("PUT")
                                .withPath("/bookClass")
                                .withBody("cid=7936160")
                                .withCookies(
                                        new Cookie("PHPSESSID", "9alb81bkiav0nffo0r8m9vf5s3")
                                )
                )
                .respond(
                        new HttpResponse()
                                .withStatusCode(200)
                                .withHeaders(
                                        new Header("Content-Type", "application/json; charset=utf-8"),
                                        new Header("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0")
                                )
                                .withBody("{\"errorCode\":200,\"errorMsg\":\"\\u7ea6\\u8bfe\\u6210\\u529f\"}")
                                .withDelay(TimeUnit.MILLISECONDS, 100)
                );
    }

    public void stopServer() {
        mockServer.stop();
    }
}
