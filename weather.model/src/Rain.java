import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Rain {

    private String h1;
    private String h3;

    @JsonGetter("1h")
    public String getH1() {
        return h1;
    }

    @JsonSetter("1h")
    public void setH1(String h1) {
        this.h1 = h1;
    }

    @JsonGetter("3h")
    public String getH3() {
        return h3;
    }

    @JsonSetter("3h")
    public void setH3(String h3) {
        this.h3 = h3;
    }

}