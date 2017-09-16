package issues.util;

import issues.entities.Issue;

/**
 * Created by rsanchpa on 16/09/2017.
 */
public final class Utilities {


    public static Issue mapIssue (Issue oldIssue, Issue newIssue) {
        if (null != oldIssue && null != newIssue) {
            if (null != newIssue.getTitle()){
                oldIssue.setTitle(newIssue.getTitle());
            }
            if (null != newIssue.getState()){
                oldIssue.setState(newIssue.getState());
            }
            if (null != newIssue.getUrl()){
                oldIssue.setUrl(newIssue.getUrl());
            }
            if (null != newIssue.getOwner()){
                oldIssue.setOwner(newIssue.getOwner());
            }
            if (null != newIssue.getLocked()){
                oldIssue.setLocked(newIssue.getLocked());
            }
            if (null != newIssue.getLabels()){
                oldIssue.setLabels(newIssue.getLabels());
            }
            if (null != newIssue.getBody()){
                if (null != newIssue.getBody().getText()){
                    oldIssue.getBody().setText(newIssue.getBody().getText());
                }
            }
        }
        return oldIssue;
    }

//    private List<String> labels;
//    private String owner;
//    private Boolean locked;
//    private Body body;
}
