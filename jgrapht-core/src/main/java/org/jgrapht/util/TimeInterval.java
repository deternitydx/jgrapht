package org.jgrapht.util;

import java.util.Date;

/**
 * Created by jrhott on 5/30/16.
 */
public class TimeInterval {

    private long start;

    private long end;

    public void setStart(long start) {
        this.start = start;
    }

    public void setStart(Date start) {
        this.start = start.getTime();
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public void setEnd(Date end) {
        this.end = end.getTime();
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        return this.end;
    }

    public boolean inside(long time) {
        if (time >= start && time <= end) {
            return true;
        }
        return false;
    }

    public boolean inside(Date time) {
        return inside(time.getTime());
    }
}
