package org.jgrapht.graph;

import org.jgrapht.util.TimeInterval;

/**
 * Created by jh2jf on 6/1/16.
 */
public class StartTimeSampling extends AbstractSampling {


    @Override
    public boolean existsIn(AbstractTemporalEdge edge, TimeInterval interval) {
        return edge.existsAt(interval.getStart());
    }
}
