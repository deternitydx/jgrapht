package org.jgrapht.graph;

import org.jgrapht.util.TimeInterval;

/**
 * Created by jh2jf on 6/1/16.
 */
abstract class AbstractSampling {

    public abstract boolean existsIn(AbstractTemporalEdge edge, TimeInterval interval);
}
