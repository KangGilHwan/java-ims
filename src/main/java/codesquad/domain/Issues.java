package codesquad.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.List;

@Embeddable
public class Issues {

    @JsonIgnore
    @OneToMany(mappedBy = "milestone")
    private List<Issue> issues;

    public Issues() {
    }

    public Issues(List<Issue> issues){
        this.issues = issues;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public long numberOfOpen() {
        return issues.stream().filter(issue -> !issue.isClosed()).count();
    }

    public int sizeOfIssues() {
        return issues.size();
    }
}
