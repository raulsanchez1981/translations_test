package issues.entities;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rsanchpa on 16/09/2017.
 */
public class Body implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Boolean result = false;
        if (o instanceof Body) {
            Body body = (Body) o;
            equalsBuilder.append(text, body.text);
            equalsBuilder.append(createDate, body.createDate);
            result = equalsBuilder.isEquals();
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
