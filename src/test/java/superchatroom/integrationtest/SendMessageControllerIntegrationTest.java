package superchatroom.integrationtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SendMessageControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetTopicsAPI() {
        String body = this.restTemplate.getForObject("/topics", String.class);
        assertThat(body).isEqualTo("[{\"topic\":\"Weather\",\"displayName\":\"天气\"},{\"topic\":\"Technology\",\"displayName\":\"Technology\"}]");
    }
}