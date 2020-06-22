package service;

import model.Event;
import projectConstantsAndEnums.activityCategoryEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EventService {
    private Integer fileIndex = 1;
    private BigDecimal totalScore = BigDecimal.ZERO;

    public EventService() {
    }

    public Event createEvent(String athleteScore) {
        String eventName = "";
        BigDecimal score = new BigDecimal("0");

        if (this.fileIndex == activityCategoryEnum.AC_MTS100.getIndexFile()) {
            eventName = activityCategoryEnum.AC_MTS100.getScoreCalculationEnum().getName();
            score = activityCategoryEnum.AC_MTS100.getScoreCalculationEnum().toDoCalculate(athleteScore);
        } else if (this.fileIndex == activityCategoryEnum.AC_LONGJUMP.getIndexFile()) {
            eventName = activityCategoryEnum.AC_LONGJUMP.getScoreCalculationEnum().getName();
            score = activityCategoryEnum.AC_LONGJUMP.getScoreCalculationEnum().toDoCalculate(athleteScore);
        } else if (this.fileIndex == activityCategoryEnum.AC_SHOTPUT.getIndexFile()) {
            eventName = activityCategoryEnum.AC_SHOTPUT.getScoreCalculationEnum().getName();
            score = activityCategoryEnum.AC_SHOTPUT.getScoreCalculationEnum().toDoCalculate(athleteScore);
        } else if (this.fileIndex == activityCategoryEnum.AC_HIGHJUMP.getIndexFile()) {
            eventName = activityCategoryEnum.AC_HIGHJUMP.getScoreCalculationEnum().getName();
            score = activityCategoryEnum.AC_HIGHJUMP.getScoreCalculationEnum().toDoCalculate(athleteScore);
        } else if (this.fileIndex == activityCategoryEnum.AC_MTS400.getIndexFile()) {
            eventName = activityCategoryEnum.AC_MTS100.getScoreCalculationEnum().getName();
            score = activityCategoryEnum.AC_MTS400.getScoreCalculationEnum().toDoCalculate(athleteScore);
        } else if (this.fileIndex == activityCategoryEnum.AC_HURDLESMTS110.getIndexFile()) {
            eventName = activityCategoryEnum.AC_HURDLESMTS110.getScoreCalculationEnum().getName();
            score = activityCategoryEnum.AC_HURDLESMTS110.getScoreCalculationEnum().toDoCalculate(athleteScore);
        } else if (this.fileIndex == activityCategoryEnum.AC_DISCUSTHROW.getIndexFile()) {
            eventName = activityCategoryEnum.AC_DISCUSTHROW.getScoreCalculationEnum().getName();
            score = activityCategoryEnum.AC_DISCUSTHROW.getScoreCalculationEnum().toDoCalculate(athleteScore);
        } else if (this.fileIndex == activityCategoryEnum.AC_POLEVAULT.getIndexFile()) {
            eventName = activityCategoryEnum.AC_POLEVAULT.getScoreCalculationEnum().getName();
            score = activityCategoryEnum.AC_POLEVAULT.getScoreCalculationEnum().toDoCalculate(athleteScore);
        } else if (this.fileIndex == activityCategoryEnum.AC_JAVELINTHROW.getIndexFile()) {
            eventName = activityCategoryEnum.AC_JAVELINTHROW.getScoreCalculationEnum().getName();
            score = activityCategoryEnum.AC_JAVELINTHROW.getScoreCalculationEnum().toDoCalculate(athleteScore);
        } else if (this.fileIndex == activityCategoryEnum.AC_MTS1500.getIndexFile()) {
            eventName = activityCategoryEnum.AC_MTS1500.getScoreCalculationEnum().getName();
            score = activityCategoryEnum.AC_MTS1500.getScoreCalculationEnum().toDoCalculate(athleteScore);
        }
        this.fileIndex++;
        this.totalScore = this.totalScore.add(score).setScale(2, RoundingMode.DOWN);
        return new Event(eventName, athleteScore, score);
    }
}
