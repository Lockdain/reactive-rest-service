package app;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // starting a server on a 'RANDOM_PORT'
@Slf4j
public class GreetingRouterTest {

    // The client is created by Spring boot automatically
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testHello() {
        for (int i = 0; i < 20; i++) {
            webTestClient
                    // Create a test request ot the endpoint
                    .get().uri("/hello")
                    .accept(MediaType.TEXT_PLAIN)
                    .exchange()
                    // use the dedicated DSL to test assertions against the response
                    .expectStatus().isOk()
                    .expectBody(String.class).isEqualTo("Hello, Spring!");
            log.info("GOTCHA REQUEST: " + i + 1 + " BOOYAKA!");
        }
    }
}
