package ll.opensource.Bean;

/**
 * Created by Percy on 11-9 0009.
 */

public class PreviewImageBean {

    private String type;
    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PreviewImageBean{" +
        "type='" + type + '\'' +
        ", content='" + content + '\'' +
        '}';
    }
}
