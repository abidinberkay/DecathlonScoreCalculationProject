package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement
@XmlType(propOrder = {"name", "finalPosition", "totalScore", "event"})
public class Athlete {

    private String name;
    private BigDecimal totalScore;
    private String finalPosition;
    private List<Event> event;

    public Athlete(String name, BigDecimal totalScore, String finalPosition, List<Event> event) {
        this.name = name;
        this.totalScore = totalScore;
        this.finalPosition = finalPosition;
        this.event = event;
    }

    public Athlete() {
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    @XmlElement
    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public String getFinalPosition() {
        return finalPosition;
    }

    @XmlElement
    public void setFinalPosition(String finalPosition) {
        this.finalPosition = finalPosition;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", totalScore=" + totalScore +
                ", finalPosition='" + finalPosition + '\'' +
                '}';
    }
}
