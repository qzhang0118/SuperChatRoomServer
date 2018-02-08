package superchatroom;

/**
 * Server-side representation of topic, message and username.
 */
public class Message {
    private String topic;
    private String message;
    private String username;

    public Message(String topic, String message, String username) {
        this.topic = topic;
        this.message = message;
        this.username = username;
    }

    public Message() {}

    public String getTopic() {
        return topic;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }
}