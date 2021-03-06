package superchatroom;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Sends message to Mqtt client.
 */
@RestController
public class SendMessageController {
    private static MqttClient client;

    static {
        try {
            client = new MqttClient("tcp://test.mosquitto.org", MqttClient.generateClientId());
            client.connect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public void sendMessage(@RequestBody Message message) throws MqttException {
        String receivedMessage = message.getUsername() + ":" + message.getMessage();
        if (receivedMessage != null && !receivedMessage.isEmpty()) {
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setPayload(receivedMessage.getBytes());
            client.publish(message.getTopic(), mqttMessage);
        }
    }

    @RequestMapping(value="/topics", method = RequestMethod.GET)
    public List<Topic> getTopics() {
        List<Topic> topicList = new ArrayList<>();
        Topic weatherTopic = new Topic("Weather", "天气");
        Topic technologyTopic = new Topic("Technology", "Technology");
        topicList.add(weatherTopic);
        topicList.add(technologyTopic);
        return topicList;
    }
}
