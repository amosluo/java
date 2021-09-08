package com.amos.inputDto;

public class UnitMessage {
    private String buildingCode;
    private Integer unitCount;

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    @Override
    public String toString() {
        return "UnitMessage{" +
                "buildingCode='" + buildingCode + '\'' +
                ", unitCount=" + unitCount +
                '}';
    }

    public UnitMessage() {
    }

    public UnitMessage(String buildingCode, Integer unitCout) {
        this.buildingCode = buildingCode;
        this.unitCount = unitCout;
    }
}
