/////////////////////////////////////////////////////////////////////////
//
// © University of Southampton IT Innovation Centre, 2017
//
// Copyright in this software belongs to University of Southampton
// IT Innovation Centre of Gamma House, Enterprise Road, 
// Chilworth Science Park, Southampton, SO16 7NS, UK.
//
// This software may not be used, sold, licensed, transferred, copied
// or reproduced in whole or in part in any manner or form or in or
// on any media by any person other than in accordance with the terms
// of the Licence Agreement supplied with the software, or otherwise
// without the prior written consent of the copyright owners.
//
// This software is distributed WITHOUT ANY WARRANTY, without even the
// implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
// PURPOSE, except where stated in the Licence Agreement supplied with
// the software.
//
//      Created By :            Vegard Engen
//      Created Date :          2017-02-02
//      Created for Project :   HUMANE
//
/////////////////////////////////////////////////////////////////////////
package uk.ac.soton.itinnovation.hmncore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a node in a HMN.
 *
 * @author Vegard Engen
 */
public class Node implements Serializable
{
    protected String nodeID;
    protected List<Edge> inboundEdges;
    protected List<Edge> outboundEdges;

    // This HMN object is needed for remove methods, to help synchronise with the "master" list in 
    // the HMN object. Also agents may need access to (all) artefacts and other agents,
    // which we can provide via this HMN object.
    protected HMN hmn;
    
    /**
     * Default constructor, initialising empty connection lists.
     */
    public Node()
    {
        nodeID = "";
        inboundEdges = new ArrayList<>();
        outboundEdges = new ArrayList<>();
    }
    
    /**
     * Calls the default constructor and sets the ID of the node.
     * @param nodeID The ID of the node.
     */
    public Node(String nodeID)
    {
        this.nodeID = nodeID;
    }
    
    /**
     * Calls the default constructor, sets the ID of the node and initialises the 
     * connection lists with the lists provided as arguments.
     *
     * @param nodeID The ID of the node.
     * @param inboundEdges List of inbound edges.
     * @param outboundEdges List of outbound edges.
     */
    public Node(String nodeID, List<Edge> inboundEdges, List<Edge> outboundEdges)
    {
        this(nodeID);

        if (inboundEdges != null) {
            this.inboundEdges.addAll(inboundEdges);
        }

        if (outboundEdges != null) {
            this.outboundEdges.addAll(outboundEdges);
        }
    }
    
    /**
     * Constructor to set a reference to the HMN.
     * @param hmn Human-machine network object (reference).
     */
    public Node(HMN hmn)
    {
        this.hmn = hmn;
    }
    
    /**
     * Calls the default constructor and sets the ID of the node.
     * @param hmn Human-machine network object (reference).
     * @param nodeID The ID of the node.
     */
    public Node(HMN hmn, String nodeID)
    {
        this(hmn);
        this.nodeID = nodeID;
    }

    /**
     * Calls the default constructor, sets the ID of the node and initialises the 
     * connection lists with the lists provided as arguments.
     *
     * @param hmn Human-machine network object (reference).
     * @param nodeID The ID of the node.
     * @param inboundEdges List of inbound edges.
     * @param outboundEdges List of outbound edges.
     */
    public Node(HMN hmn, String nodeID, List<Edge> inboundEdges, List<Edge> outboundEdges)
    {
        this(hmn, nodeID);

        if (inboundEdges != null) {
            this.inboundEdges.addAll(inboundEdges);
        }

        if (outboundEdges != null) {
            this.outboundEdges.addAll(outboundEdges);
        }
    }

    /**
     * Get the ID of the node.
     * @return String representing the ID of the node.
     */
    public String getNodeID()
    {
        return nodeID;
    }

    /**
     * Sets the ID of the node.
     * @param nodeID String representing the ID of the node.
     */
    public void setNodeID(String nodeID)
    {
        this.nodeID = nodeID;
    }

    /**
     * Get all the inbound edges to the node.
     * @return List of Edge objects.
     */
    public List<Edge> getInboundEdges()
    {
        return inboundEdges;
    }

    /**
     * Set all the inbound edges to the node.
     * @param inboundEdges List of Edge objects.
     */
    public void setInboundEdges(List<Edge> inboundEdges)
    {
        this.inboundEdges = inboundEdges;
    }
    
    /**
     * Create an inbound edge.
     * @param id ID of the edge.
     * @param sinkNode The node from which the directional edge stems from.
     * @param addToHMN Flag to say if the edge should also be added to the HMN's "master" list of edges.
     * @return An Edge object.
     */
    public Edge createInboundEdge(String id, Node sinkNode, boolean addToHMN)
    {
        Edge e = new Edge();
        
        e.setEdgeID(nodeID);
        e.setSourceNode(sinkNode);
        e.setSinkNode(this);
        
        if (addToHMN) {
            hmn.addEdge(e);
        }
        
        return e;
    }
    
    /**
     * Create an inbound edge.
     * @param id ID of the edge.
     * @param srcNode The node from which the directional edge stems from.
     * @param connectionType The type of connection.
     * @param srcConnection The connection from the source node (the other node) to the edge.
     * @param sinkConnection The connection from the sink node (this node) to this edge.
     * @param addToHMN Flag to say if the edge should also be added to the HMN's "master" list of edges.
     * @return An Edge object.
     */
    public Edge createInboundEdge(String id, Node srcNode, String connectionType, Connection srcConnection, Connection sinkConnection, boolean addToHMN)
    {
        Edge e = new Edge();
        
        e.setEdgeID(nodeID);
        e.setSourceNode(srcNode);
        e.setSinkNode(this);
        e.addConnectionSet(connectionType, srcConnection, sinkConnection);
        
        if (addToHMN) {
            hmn.addEdge(e);
        }
        
        return e;
    }
    
    /**
     * Add an inbound edge.
     * @param edge Edge object
     */
    public void addInboundEdge(Edge edge)
    {
        this.inboundEdges.add(edge);
    }
    
    /**
     * Add a list of inbound edges.
     * @param inboundEdges List of Edge objects
     */
    public void addInboundEdges(List<Edge> inboundEdges)
    {
        this.inboundEdges.addAll(inboundEdges);
    }
    
    /**
     * Removes an inbound edge, if it exists.
     * @param edge Edge object to be removed.
     * @param removeFromHMN A flag to signifify if the edge should be removed from the HMN's "master" list.
     * @throws NullPointerException If the Edge object is NULL.
     * @return True if the edge was successfully removed; false otherwise.
     */
    public boolean removeInboundEdge(Edge edge, boolean removeFromHMN) throws NullPointerException
    {
        if (edge == null) {
            throw new NullPointerException("Cannot remove the inbound edge from the Node as the object provided was NULL");
        }
        
        if (inboundEdges.remove(edge)) {
            if (removeFromHMN) {
                return hmn.removeEdge(edge);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Get all outbound edges.
     * @return List of Edge objects.
     */
    public List<Edge> getOutboundEdges()
    {
        return outboundEdges;
    }

    /**
     * Set all outbound edges.
     * @param outboundEdges List of Edge objects.
     */
    public void setOutboundEdges(List<Edge> outboundEdges)
    {
        this.outboundEdges = outboundEdges;
    }
    
    /**
     * Create an outbound edge.
     * @param id ID of the edge.
     * @param sinkNode The the sink (other) node, at the end of this directed edge.
     * @param addToHMN Flag to say if the edge should also be added to the HMN's "master" list of edges.
     * @return An Edge object
     */
    public Edge createOutboundEdge(String id, Node sinkNode, boolean addToHMN)
    {
        Edge e = new Edge();
        
        e.setEdgeID(nodeID);
        e.setSourceNode(this);
        e.setSinkNode(sinkNode);
        
        if (addToHMN) {
            hmn.addEdge(e);
        }
        
        return e;
    }
    
    /**
     * Create an outbound edge.
     * @param id ID of the edge.
     * @param sinkNode The node to which the directional edge goes to.
     * @param connectionType The type of connection.
     * @param srcConnection The connection from the source node (this node) to the edge.
     * @param sinkConnection The connection from the sink node (the other node) to this edge.
     * @param addToHMN Flag to say if the edge should also be added to the HMN's "master" list of edges.
     * @return An Edge object.
     */
    public Edge createOutboundEdge(String id, Node sinkNode, String connectionType, Connection srcConnection, Connection sinkConnection, boolean addToHMN)
    {
        Edge e = new Edge();
        
        e.setEdgeID(nodeID);
        e.setSourceNode(this);
        e.setSinkNode(sinkNode);
        e.addConnectionSet(connectionType, srcConnection, sinkConnection);
        
        if (addToHMN) {
            hmn.addEdge(e);
        }
        
        return e;
    }

    /**
     * Add an outbound edge.
     * @param edge Edge object.
     */
    public void addOutboundEdge(Edge edge)
    {
        this.outboundEdges.add(edge);
    }
    
    /**
     * Add a list of outbound edges.
     * @param outboundEdges List of Edge objects.
     */
    public void addOutboundEdges(List<Edge> outboundEdges)
    {
        this.outboundEdges.addAll(outboundEdges);
    }
    
    /**
     * Removes an outbound edge, if it exists.
     * @param edge Edge object to be removed.
     * @param removeFromHMN A flag to signifify if the edge should be removed from the HMN's "master" list.
     * @throws NullPointerException If the Edge object is NULL.
     * @return True if the edge was successfully removed; false otherwise.
     */
    public boolean removeOutboundEdge(Edge edge, boolean removeFromHMN) throws NullPointerException
    {
        if (edge == null) {
            throw new NullPointerException("Cannot remove the outbound edge from the Node as the object provided was NULL");
        }
        
        if (outboundEdges.remove(edge)) {
            if (removeFromHMN) {
                return hmn.removeEdge(edge);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    
    @Override
    public String toString()
    {
        return this.nodeID;
    }
}
