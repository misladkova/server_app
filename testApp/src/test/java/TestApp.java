import com.company.Program;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.HttpMethod;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(VertxExtension.class)
class SomeTest {

    @Test
    void http_server_check_response(Vertx vertx, VertxTestContext testContext) {
        vertx.deployVerticle(new Program(), testContext.succeeding(id -> {
            HttpClient client = vertx.createHttpClient();
            client.request(HttpMethod.GET, 8088, "localhost", "/")
                    .compose(req -> req.send().compose(HttpClientResponse::body))
                    .onComplete(testContext.succeeding(buffer -> testContext.verify(() -> {
                        assertThat(buffer.toString()).startsWith("Hello from web server ");
                        assertThat(buffer.toString()).endsWith(" with hostname " + System.getenv("HOSTNAME"));
                        testContext.completeNow();
                    })));
        }));
    }
}
