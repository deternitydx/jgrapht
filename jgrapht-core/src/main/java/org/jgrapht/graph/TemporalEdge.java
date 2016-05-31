package org.jgrapht.graph;

import org.jgrapht.util.TimeInterval;

import java.util.HashMap;

/**
 * Temporal Edge
 *
 * Created by jrhott on 5/30/16.
 */
public class TemporalEdge extends DefaultEdge {

    /**
     * Temporal edges have a function of times that they are present
     */
    private HashMap<TimeInterval, Boolean> lifeSpan;


    public TemporalEdge() {
        lifeSpan = new HashMap<>();
    }

    @Override
    protected Object getSource() {
        return super.getSource();
    }

    @Override
    protected Object getTarget() {
        return super.getTarget();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
