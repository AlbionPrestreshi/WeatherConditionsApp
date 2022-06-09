import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Snow {

    private String h3;// 3h

    @JsonGetter("3h")
    public String getH3() {
        return h3;
    }

    @JsonSetter("3h")
    public void setH3(String h3) {
        this.h3 = h3;
    }

}