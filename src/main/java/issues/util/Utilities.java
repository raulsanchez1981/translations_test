package issues.util;

import issues.entities.Issue;

/**
 * Created by rsanchpa on 16/09/2017.
 */
public final class Utilities {


    public static Issue mapIssue (Issue oldIssue, Issue newIssue) {
        if (null != oldIssue && null != newIssue) {
            if (null != newIssue.getDirection()){
                oldIssue.setDirection(newIssue.getDirection());
            }
        }
        return oldIssue;
    }
}
