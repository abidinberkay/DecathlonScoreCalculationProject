package service;

import projectConstantsAndEnums.ScoreCalculationEnum;

import java.math.BigDecimal;

public class CalculationService {

    public BigDecimal calculateForTrackEvent(BigDecimal P, ScoreCalculationEnum score) {
        return score.getValueA().multiply(new BigDecimal(Math.pow(this.substractWithoutMinusNumbers(score.getValueB(), P).doubleValue(), score.getValueC().doubleValue()))).setScale(0, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal calculateForFieldEvent(BigDecimal P, ScoreCalculationEnum score) {
        return score.getValueA().multiply(new BigDecimal(Math.pow(this.substractWithoutMinusNumbers(P, score.getValueB()).doubleValue(), score.getValueC().doubleValue()))).setScale(0, BigDecimal.ROUND_DOWN);
    }

    private BigDecimal substractWithoutMinusNumbers(BigDecimal a, BigDecimal b) {
        BigDecimal result = a.subtract(b);
        return a.subtract(b).compareTo(BigDecimal.ZERO) >= 0 ? result : BigDecimal.ZERO;
    }
}
