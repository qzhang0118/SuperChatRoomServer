package superchatroom;

/**
 * Server-side representation of topic and message.
 */
public class Message {
    private String topic;
    private String message;

    public Message(String topic, String message) {
        this.topic = topic;
        this.message = message;
    }

    public Message() {}

    public String getTopic() {
        return topic;
    }

    public String getMessage() {
        return message;
    }
}
