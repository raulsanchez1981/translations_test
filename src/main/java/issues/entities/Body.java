package issues.entities;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by rsanchpa on 16/09/2017.
 */
public class Body {

    @ApiModelProperty(notes = "Free Text", example = "I had a problem in some point...")
    private String text;
    @ApiModelProperty(hidden = true)
    private Date createDate;

    public Body() {
        this.createDate = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
