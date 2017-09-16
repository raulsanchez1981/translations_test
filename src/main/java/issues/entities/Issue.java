package issues.entities;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Issue {

    private Long id;
    private String filter;
    private String state;
    private String labels;
    private String sort;
    private String direction;
    private Date since;
    private String owner;
    private Boolean locked;

    public Issue() {
    }

    public Issue(Long id, String filter, String state, String labels, String sort, String direction, String owner) {
        this.id = id;
        this.filter = filter;
        this.state = state;
        this.labels = labels;
        this.sort = sort;
        this.direction = direction;
        this.since = new Date();
        this.owner = owner;
        this.locked = false;
    }


    @ApiModelProperty(notes = "The id of the issues", required = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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
}
