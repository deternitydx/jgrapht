package org.jgrapht.graph;

import org.jgrapht.EdgeFactory;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.util.TimeInterval;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: Would need to override much of AbstractBaseGraph to have getters and setters check
 *       the TemporalEdge's TimeInterval mapping.  May also need to remove the use of
 *       IntrusiveEdge, or at least make accessing it based on methods rather than public fields
 *       so that the TimeInterval map may be checked.
 *
 * Created by jrhott on 5/30/16.
 */
public class TimeVaryingGraph<V,E extends AbstractTemporalEdge>
        extends AbstractBaseGraph<V,E>
        implements UndirectedGraph<V,E> {

    private TimeInterval inspectionInterval;

    private AbstractSampling sampling;

    protected TimeVaryingGraph(EdgeFactory<V, E> ef, boolean allowMultipleEdges, boolean allowLoops) {
        super(ef, allowMultipleEdges, allowLoops);
    }

    public void setInspectionInterval(TimeInterval t) {
        this.inspectionInterval = t;
    }

    public void setSamplingMethod(AbstractSampling sampling) {
        this.sampling = sampling;
    }

    @Override
    public Set<E> getAllEdges(V sourceVertex, V targetVertex) {
        if (inspectionInterval == null)
            return super.getAllEdges(sourceVertex, targetVertex);
        else
            return getAllExistingEdges(sourceVertex, targetVertex);
    }

    public Set<E> getAllExistingEdges(V sourceVertex, V targetVertex) {

        HashSet<E> existingEdges = new HashSet<>();
        for (E edge: super.getAllEdges(sourceVertex, targetVertex)
             ) {
            if (sampling.existsIn(edge, inspectionInterval)) {
                existingEdges.add(edge);
            }
        }
        return existingEdges;
    }

    @Override
    public E getEdge(V sourceVertex, V targetVertex) {

        E edge = super.getEdge(sourceVertex, targetVertex);

        if (edge == null)
            return null;

        if (inspectionInterval == null)
            return edge;
        else {
            if (sampling.existsIn(edge, inspectionInterval))
                return edge;
            else
                return null;
        }
    }

    @Override
    public E addEdge(V sourceVertex, V targetVertex) {
        return super.addEdge(sourceVertex, targetVertex);
    }

    @Override
    public boolean addEdge(V sourceVertex, V targetVertex, E e) {
        return super.addEdge(sourceVertex, targetVertex, e);
    }

    @Override
    public boolean addVertex(V v) {
        return super.addVertex(v);
    }

    @Override
    public V getEdgeSource(E e) {
        return super.getEdgeSource(e);
    }

    @Override
    public V getEdgeTarget(E e) {
        return super.getEdgeTarget(e);
    }

    @Override
    public boolean containsEdge(E e) {
        return super.containsEdge(e);
    }

    @Override
    public boolean containsVertex(V v) {
        return super.containsVertex(v);
    }

    @Override
    public int degreeOf(V vertex) {
        return super.degreeOf(vertex);
    }

    @Override
    public Set<E> edgesOf(V vertex) {
        return super.edgesOf(vertex);
    }

    @Override
    public int inDegreeOf(V vertex) {
        return super.inDegreeOf(vertex);
    }

    @Override
    public Set<E> incomingEdgesOf(V vertex) {
        return super.incomingEdgesOf(vertex);
    }

    @Override
    public int outDegreeOf(V vertex) {
        return super.outDegreeOf(vertex);
    }

    @Override
    public Set<E> outgoingEdgesOf(V vertex) {
        return super.outgoingEdgesOf(vertex);
    }

    @Override
    public E removeEdge(V sourceVertex, V targetVertex) {
        return super.removeEdge(sourceVertex, targetVertex);
    }

    @Override
    public boolean removeEdge(E e) {
        return super.removeEdge(e);
    }

    @Override
    public boolean removeVertex(V v) {
        return super.removeVertex(v);
    }

    @Override
    public Set<V> vertexSet() {
        return super.vertexSet();
    }

    @Override
    public Set<E> edgeSet() {
        return super.edgeSet();
    }

    @Override
    public boolean containsEdge(V sourceVertex, V targetVertex) {
        return super.containsEdge(sourceVertex, targetVertex);
    }
}
