package org.jgrapht.graph;

import org.jgrapht.util.TimeInterval;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jh2jf on 6/1/16.
 */
abstract class AbstractTemporalEdge
        implements Cloneable,
        Serializable {
    private static final long serialVersionUID = 3258408452177932856L;

    Object source;

    Object target;

    /**
     * @see Object#clone()
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // shouldn't happen as we are Cloneable
            throw new InternalError();
        }
    }

    protected Object getSource() {
        return source;
    }

    protected Object getTarget() {
        return target;
    }

    public String toString() {
        return "(" + source + " : " + target + ")";
    }

    public abstract boolean existsAt(TimeInterval t);

    public boolean existsAt(Date t) {
        return existsAt(t.getTime());
    }

    public abstract boolean existsAt(long t);
}
