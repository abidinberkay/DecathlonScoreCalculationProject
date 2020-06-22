package model;

import java.math.BigDecimal;

public class Event {

    private String activityName;
    private String result;
    private BigDecimal score;

    public Event(String activityName, String result, BigDecimal score) {
        this.activityName = activityName;
        this.result = result;
        this.score = score;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityName='" + activityName + '\'' +
                ", result='" + result + '\'' +
                ", score=" + score +
                '}';
    }
}
