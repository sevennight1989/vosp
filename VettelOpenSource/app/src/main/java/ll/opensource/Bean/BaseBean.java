package ll.opensource.Bean;

/**
 * Created by Percy on 11-2 0002.
 */

public class BaseBean<T> {
    private String code;
    private String message;
    private T data;

    @Override
    public String toString() {
        return "BaseBean{" +
        "code='" + code + '\'' +
        ", message='" + message + '\'' +
        ", data=" + data +
        '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
