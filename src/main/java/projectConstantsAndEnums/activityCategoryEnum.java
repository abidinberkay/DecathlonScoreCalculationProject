package projectConstantsAndEnums;

public enum activityCategoryEnum {
    AC_MTS100(1, ScoreCalculationEnum.SCE_MTS100),
    AC_LONGJUMP(2, ScoreCalculationEnum.SCE_LONGJUMP),
    AC_SHOTPUT(3, ScoreCalculationEnum.SCE_SHOTPUT),
    AC_HIGHJUMP(4, ScoreCalculationEnum.SCE_HIGHJUMP),
    AC_MTS400(5, ScoreCalculationEnum.SCE_MTS400),
    AC_HURDLESMTS110(6, ScoreCalculationEnum.SCE_HURDLESMTS110),
    AC_DISCUSTHROW(7, ScoreCalculationEnum.SCE_DISCUSTHROW),
    AC_POLEVAULT(8, ScoreCalculationEnum.SCE_POLEVAULT),
    AC_JAVELINTHROW(9, ScoreCalculationEnum.SCE_JAVELINTHROW),
    AC_MTS1500(10, ScoreCalculationEnum.SCE_MTS1500);

    private int indexFile;
    private ScoreCalculationEnum scoreCalculationEnum;

    private activityCategoryEnum(int indexFile, ScoreCalculationEnum scoreCalculationEnum) {
        this.indexFile = indexFile;
        this.scoreCalculationEnum = scoreCalculationEnum;
    }

    public int getIndexFile() {
        return indexFile;
    }

    public void setIndexFile(int indexFile) {
        this.indexFile = indexFile;
    }

    public ScoreCalculationEnum getScoreCalculationEnum() {
        return scoreCalculationEnum;
    }

    public void setScoreCalculationEnum(ScoreCalculationEnum scoreCalculationEnum) {
        this.scoreCalculationEnum = scoreCalculationEnum;
    }


}
