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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A class representing an Edge between two Nodes in the HMN, which has a start
 * and an end Connection to the two respective Nodes.
 *
 * @see Connection
 * @see Node
 * @author Vegard Engen
 */
public class Edge implements Serializable
{
    private String edgeID;
    private Node sourceNode;
    private Node sinkNode;
    private Map<String, Connection> sourceConnections; // connections of different types (the String key) from source node encoding properties affecting how the source node may interact with the sink node
    private Map<String, Connection> sinkConnections; // connection of different types (the String key) to sink node encoding properties affecting how the destination node may react to interactions from the source node
    private Map<String, EdgeStats> edgeConnectionStats; // key = connection type
    private EdgeStats edgeStats; // assumed to aggregate stats across all connection edge stats objects

    /**
     * Default constructor, initialising the properties of the Edge class.
     */
    public Edge()
    {
        sourceConnections = new HashMap<>();
        sinkConnections = new HashMap<>();
        edgeConnectionStats = new HashMap<>();
        edgeStats = new EdgeStats();
    }
    
    /**
     * Constructor for setting a minimum set of properties of the Edge class.
     * Sets a random UUID as the edge ID.
     * @param srcNode The Node at the SOURCE end of the edge.
     * @param sinkNode The Node at the SINK end of the edge.
     */
    public Edge(Node srcNode, Node sinkNode)
    {
        this();
        this.sourceNode = srcNode;
        this.sinkNode = sinkNode;
        this.edgeID = UUID.randomUUID().toString();
    }

    /**
     * Constructor for setting key properties of the Edge class, including it's ID, 
     * nodes and a set of connections from each to the edge.
     * Sets a random UUID as the edge ID.
     * @param srcNode The Node at the SOURCE end of the edge.
     * @param sinkNode The Node at the SINK end of the edge.
     * @param conType A String representing the name of the type of connection to be added.
     * @param srcCon Connection from the SOURCE node to the edge.
     * @param sinkCon Connection from the SINK node to the edge.
     */
    public Edge(Node srcNode, Node sinkNode, String conType, Connection srcCon, Connection sinkCon)
    {
        this(srcNode, sinkNode);
        this.sourceConnections.put(conType, srcCon);
        this.sinkConnections.put(conType, sinkCon);
    }
    
    /**
     * Constructor for setting a minimum set of properties of the Edge class.
     * @param eID The ID of the edge.
     * @param srcNode The Node at the SOURCE end of the edge.
     * @param sinkNode The Node at the SINK end of the edge.
     */
    public Edge(String eID, Node srcNode, Node sinkNode)
    {
        this();
        this.edgeID = eID;
        this.sourceNode = srcNode;
        this.sinkNode = sinkNode;
    }

    /**
     * Constructor for setting key properties of the Edge class, including it's ID, 
     * nodes and a set of connections from each to the edge.
     * @param eID The ID of the edge.
     * @param srcNode The Node at the SOURCE end of the edge.
     * @param sinkNode The Node at the SINK end of the edge.
     * @param conType A String representing the name of the type of connection to be added.
     * @param srcCon Connection from the SOURCE node to the edge.
     * @param sinkCon Connection from the SINK node to the edge.
     */
    public Edge(String eID, Node srcNode, Node sinkNode, String conType, Connection srcCon, Connection sinkCon)
    {
        this(eID, srcNode, sinkNode);
        this.sourceConnections.put(conType, srcCon);
        this.sinkConnections.put(conType, sinkCon);
    }

    /**
     * Get the ID of the edge.
     * @return A string representing the ID of the edge.
     */
    public String getEdgeID()
    {
        return edgeID;
    }

    /**
     * Set the ID of the edge.
     * @param edgeID A string representing the ID of the edge.
     */
    public void setEdgeID(String edgeID)
    {
        this.edgeID = edgeID;
    }

    /**
     * Get the source node of the edge.
     * @return Node object.
     */
    public Node getSourceNode()
    {
        return sourceNode;
    }

    /**
     * Set the source node of the edge.
     * @param sourceNode Node object.
     */
    public void setSourceNode(Node sourceNode)
    {
        this.sourceNode = sourceNode;
    }

    /**
     * Get the sink node of the edge.
     * @return Node object.
     */
    public Node getSinkNode()
    {
        return sinkNode;
    }

    /**
     * Set the sink node of the edge.
     * @param sinkNode Node object.
     */
    public void setSinkNode(Node sinkNode)
    {
        this.sinkNode = sinkNode;
    }

    /**
     * Get all connections for the source node.
     * @return Map of connections, where the Key is a string representing the connection name/ID.
     */
    public Map<String, Connection> getSourceConnections()
    {
        return sourceConnections;
    }

    /**
     * Set the connections for the source node.
     * @param sourceConnections Map of connections, where the Key is a string representing the connection name/ID.
     */
    public void setSourceConnections(Map<String, Connection> sourceConnections)
    {
        this.sourceConnections = sourceConnections;
    }
    
    /**
     * Add connections for the source node.
     * @param sourceConnections Map of connections, where the Key is a string representing the connection name/ID.
     */
    public void addSourceConnections(Map<String, Connection> sourceConnections)
    {
        this.sourceConnections.putAll(sourceConnections);
    }
    
    /**
     * Add a connection for the source node.
     * @param conType A string representing the connection name/ID.
     * @param con The connection object.
     */
    public void addSourceConnection(String conType, Connection con)
    {
        this.sourceConnections.put(conType, con);
    }

    /**
     * Get all connections for the sink node.
     * @return Map of connections, where the Key is a string representing the connection name/ID.
     */
    public Map<String, Connection> getSinkConnections()
    {
        return sinkConnections;
    }

    /**
     * Set the connections for the sink node.
     * @param sinkConnections Map of connections, where the Key is a string representing the connection name/ID.
     */
    public void setSinkConnections(Map<String, Connection> sinkConnections)
    {
        this.sinkConnections = sinkConnections;
    }
    
    /**
     * Add connections for the sink node.
     * @param sinkConnections Map of connections, where the Key is a string representing the connection name/ID.
     */
    public void addSinkConnections(Map<String, Connection> sinkConnections)
    {
        this.sinkConnections.putAll(sinkConnections);
    }
    
    /**
     * Add a connection for the sink node.
     * @param conType A string representing the connection name/ID.
     * @param con The connection object.
     */
    public void addSinkConnection(String conType, Connection con)
    {
        this.sinkConnections.put(conType, con);
    }
    
    /**
     * Add a set of connections, one for each of the nodes the edge connects.
     * @param connectionType A string representing the connection name/ID.
     * @param srcConnection Connection object for the source node.
     * @param sinkConnection Connection object for the sink node.
     */
    public void addConnectionSet(String connectionType, Connection srcConnection, Connection sinkConnection)
    {
        this.addSourceConnection(connectionType, srcConnection);
        this.addSinkConnection(connectionType, sinkConnection);
    }

    /**
     * Get edge stats pertaining to the specific connections.
     * @return Map of edge stats, where the Key is a string representing the connection name/ID.
     */
    public Map<String, EdgeStats> getEdgeConnectionStats()
    {
        return edgeConnectionStats;
    }

    /**
     * Sets the edge connection stats.
     * @param edgeStats Map of edge stats, where the Key is a string representing the connection name/ID.
     */
    public void setEdgeConnectionStats(Map<String, EdgeStats> edgeStats)
    {
        this.edgeConnectionStats = edgeStats;
    }
    
    /**
     * Add edge stats pertaining to a type of connection (the key).
     * @param edgeStats Map of edge stats, where the Key is a string representing the connection name/ID.
     */
    public void addEdgeConnectionStats(Map<String, EdgeStats> edgeStats)
    {
        this.edgeConnectionStats.putAll(edgeStats);
    }
    
    /**
     * Add an age stats object pertaing to a type of connection.
     * @param conType A string representing the name/ID of the connection type.
     * @param edgeStats An EdgeStats object.
     */
    public void addEdgeConnectionStats(String conType, EdgeStats edgeStats)
    {
        this.edgeConnectionStats.put(conType, edgeStats);
    }
    
    /**
     * Get edge stats (assumed to be aggregated across all connections).
     * @return EdgeStats object.
     */
    public EdgeStats getEdgeStats()
    {
        return edgeStats;
    }

    /**
     * Sets the edge stats.
     * @param edgeStats EdgeStats object.
     */
    public void setEdgeStats(EdgeStats edgeStats)
    {
        this.edgeStats = edgeStats;
    }
}
