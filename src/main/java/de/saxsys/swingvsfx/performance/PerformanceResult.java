package de.saxsys.swingvsfx.performance;

import java.util.concurrent.TimeUnit;

public class PerformanceResult {

    private long startTimeinNano;
    private long endTimeInNano;

    public PerformanceResult(long startTimeinNano, long endTimeInNano) {
        this.startTimeinNano = startTimeinNano;
        this.endTimeInNano = endTimeInNano;
    }

    public long getStartTimeinNano() {
        return startTimeinNano;
    }

    public void setStartTimeinNano(long startTimeinNano) {
        this.startTimeinNano = startTimeinNano;
    }

    public long getEndTimeInNano() {
        return endTimeInNano;
    }

    public void setEndTimeInNano(long endTimeInNano) {
        this.endTimeInNano = endTimeInNano;
    }

    public String getPerformanceInSeconds() {
        return TimeUnit.NANOSECONDS.toSeconds(this.endTimeInNano - this.startTimeinNano) + "."
                + TimeUnit.NANOSECONDS.toMillis(this.endTimeInNano - this.startTimeinNano);
    }   

}
