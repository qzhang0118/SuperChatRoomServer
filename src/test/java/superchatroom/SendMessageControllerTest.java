package superchatroom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SendMessageController.class)
public class SendMessageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetTopics_noInput_twoStaticTopics() throws Exception {
        this.mockMvc.perform(get("/topics"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string("[{\"topic\":\"Weather\",\"displayName\":\"天气\"},{\"topic\":\"Technology\",\"displayName\":\"Technology\"}]"));
    }
}