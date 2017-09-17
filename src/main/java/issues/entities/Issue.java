package issues.entities;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Issue implements Serializable {



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

    @Override
    public boolean equals(Object o) {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Boolean result = false;
        if (o instanceof Issue) {
            Issue issue = (Issue) o;
            equalsBuilder.append(id, issue.id);
            equalsBuilder.append(title, issue.title);
            equalsBuilder.append(state, issue.state);
            equalsBuilder.append(url, issue.url);
            equalsBuilder.append(since, issue.since);
            equalsBuilder.append(owner, issue.owner);
            equalsBuilder.append(locked, issue.locked);
            equalsBuilder.append(body, issue.body);
            result = equalsBuilder.isEquals();
        }
        return result;
    }



    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (since != null ? since.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (locked ? 1 : 0);
        return result;
    }

}
