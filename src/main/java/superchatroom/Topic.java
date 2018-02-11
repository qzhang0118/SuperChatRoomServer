package superchatroom;

/**
 *
 */
public class Topic {
    private String topic;
    private String displayName;

    public Topic() {

    }

    public Topic(String topic, String displayName) {
        this.topic = topic;
        this.displayName = displayName;
    }

    public String getTopic() {
        return topic;
    }

    public String getDisplayName() {
        return displayName;
    }
}
