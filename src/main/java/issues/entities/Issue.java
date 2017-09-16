package issues.entities;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Issue {



    @Id
    @ApiModelProperty(notes = "The id of the issues", required = true, hidden = true)
    private String id;
    @ApiModelProperty(notes = "The Title of the issues", required = true, example = "Title Issue")
    private String title;
    @ApiModelProperty(notes = "The State of the issues", required = true, example = "Open")
    private String state;
    private List<String> labels;
    @ApiModelProperty(notes = "Url", example = "www.google.com")
    private String url;
    @ApiModelProperty(hidden = true)
    private Date since;
    @ApiModelProperty(hidden = true)
    private String owner;
    @ApiModelProperty(hidden = true)
    private Boolean locked;
    private Body body;


    public Issue() {
        this.locked = false;
        this.since = new Date();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
