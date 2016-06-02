package org.jgrapht.graph;

import org.jgrapht.util.TimeInterval;

import java.util.Date;
import java.util.HashMap;

/**
 * Temporal Edge
 *
 * Created by jrhott on 5/30/16.
 */
public class TemporalEdge extends AbstractTemporalEdge {

    /**
     * Temporal edges have a function of times that they are present
     */
    private HashMap<TimeInterval, Boolean> lifeSpan;


    public TemporalEdge() {
        lifeSpan = new HashMap<>();
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public Object getTarget() {
        return super.getTarget();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void addExistInterval(TimeInterval t) {
        // Eventually this will need to check for overlapping time intervals and combine.  For now,
        // I'm assuming they are non-overlapping
        lifeSpan.put(t, true);
    }

    @Override
    public boolean existsAt(TimeInterval t) {
        // currently not supported
        return false;
    }

    @Override
    public boolean existsAt(long t) {
        for (TimeInterval key : lifeSpan.keySet()
             ) {
            if (key.inside(t)) {
                return lifeSpan.get(key);
            }
        }
        return false;
    }
}
