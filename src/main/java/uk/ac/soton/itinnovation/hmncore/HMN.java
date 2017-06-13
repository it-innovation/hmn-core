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
import java.util.GregorianCalendar;
import java.util.List;

/**
 * A class representing a Human-Machine Network (HMN), comprising Nodes and
 * Edges. Nodes can be either agents or artefacts. The latter having no agency.
 * 
 * @see Node
 * @see Agent
 * @see Artefact
 * @see Edge
 *
 * @author Vegard Engen
 */
public class HMN implements Serializable
{
    // may benefit from changing the Node usage here to Agent and Artefact, respectively
    protected String name;
    protected List<Agent> agents;
    protected List<Artefact> artefacts;
    protected List<Edge> edges;
    private GregorianCalendar currentDateTime;

    /**
     * Default constructor, initialising empty node and edge lists.
     */
    public HMN()
    {
        agents = new ArrayList<>();
        artefacts = new ArrayList<>();
        edges = new ArrayList<>();
    }
    
    /**
     * Constructor setting the name of the HMN.
     * @param name Name of the HMN.
     */
    public HMN(String name)
    {
        this();
        this.name = name;
    }

    /**
     * Constructor to initialise the node and edge lists with the lists provided
     * as arguments.
     *
     * @param agents List of Agents representing agents (humans or machines).
     * @param artefacts List of Artefacts representing artefacts.
     * @param edges List of Edges.
     */
    public HMN(List<Agent> agents, List<Artefact> artefacts, List<Edge> edges)
    {
        this();
        if (agents != null) {
            this.agents.addAll(agents);
        }
        if (artefacts != null) {
            this.artefacts.addAll(artefacts);
        }
        if (edges != null) {
            this.edges.addAll(edges);
        }
    }

    /**
     * Get the name of HMN.
     * @return The name of the HMN.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the name of the HMN.
     * @param name A string of the name of the HMN.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Removes an agent from the HMN, given the ID provided.
     * @param id The ID of the agent to be removed.
     * @return Returns if the node was found and removed successfully; False if not found, or not removed successfully.
     */
    public boolean removeAgent(String id)
    {
        for (Node n : agents) {
            if (n.getNodeID().equals(id)) {
                return agents.remove(n);
            }
        }
        return false;
    }
    
    /**
     * Removes an agent from the HMN, given the Node object provided.
     * @param n Node object to be removed.
     * @return Returns true if the HMN contained the node and it was removed successfully; false otherwise.
     * @throws NullPointerException If n is NULL.
     */
    public boolean removeAgent(Node n) throws NullPointerException
    {
        if (n == null) {
            throw new NullPointerException("Cannot remove the node from the HMN as the object provided was NULL");
        }
        
        return agents.remove(n);
    }
    
    /**
     * Removes an artefact from the HMN, given the ID provided.
     * @param id The ID of the artefact to be removed.
     * @return Returns true if the node was found and removed successfully; False if not found, or not removed successfully.
     */
    public boolean removeArtefact(String id)
    {
        for (Node n : artefacts) {
            if (n.getNodeID().equals(id)) {
                return artefacts.remove(n);
            }
        }
        return false;
    }
    
    /**
     * Removes an artefact from the HMN, given the Node object provided.
     * @param n Node object to be removed.
     * @return Returns true if the HMN contained the node and it was removed successfully; false otherwise.
     * @throws NullPointerException If n is NULL.
     */
    public boolean removeArtefact(Node n) throws NullPointerException
    {
        if (n == null) {
            throw new NullPointerException("Cannot remove the node from the HMN as the object provided was NULL");
        }
        
        return artefacts.remove(n);
    }
    
    /**
     * Removes an edge from the HMN, given the ID provided.
     * @param id ID of the edge to be removed.
     * @return Returns true if the HMN contained the edge and it was removed successfully; false otherwise.
     */
    public boolean removeEdge(String id)
    {
        for (Edge e : edges) {
            if (e.getEdgeID().equals(id)) {
                return edges.remove(e);
            }
        }
        return false;
    }
    
    /**
     * Removes an edge from the HMN, given the Edge object provided.
     * @param e Edge object to be removed.
     * @return Returns true if the HMN contained the edge and it was removed successfully; false otherwise.
     * @throws NullPointerException If e is NULL.
     */
    public boolean removeEdge(Edge e) throws NullPointerException
    {
        if (e == null) {
            throw new NullPointerException("Cannot remove the edge from the HMN as the object provided was NULL");
        }
        
        return edges.remove(e);
    }

    /**
     * Get all Agent nodes in the HMN.
     * @return List of Agent objects.
     */
    public List<Agent> getAgents()
    {
        return agents;
    }

    /**
     * Set all Agent nodes in the HMN according to the provided list.
     * This will replace the existing list without calling any clean-up methods.
     * Consider using the add-methods if this is not desirable.
     * @param agents List of Agents
     */
    public void setAgents(List<Agent> agents)
    {
        // this.nodes.clear(); // Left this here in case there would be an advantage to clear the list first
        this.agents = agents;
    }
    
    /**
     * Get all Artefact nodes in the HMN.
     * @return List of Artefact objects.
     */
    public List<Artefact> getArtefacts()
    {
        return artefacts;
    }
    
    /**
     * Set all Artefact nodes in the HMN according to the provided list.
     * This will replace the existing list without calling any clean-up methods. 
     * Consider using the add-methods if this is not desirable.
     * @param artefacts List of Artefact nodes
     */
    public void setArtefacts(List<Artefact> artefacts)
    {
        // this.nodes.clear(); // Left this here in case there would be an advantage to clear the list first
        this.artefacts = artefacts;
    }
    
    /**
     * Add Agent nodes to the HMN.
     * @param agents List of Agents to be added to the agent list.
     */
    public void addAgents(List<Agent> agents)
    {
        this.agents.addAll(agents);
    }
    
    /**
     * Add an Agent node to the HMN.
     * @param node An Agent object to add to the agent list of Nodes.
     */
    public void addAgent(Agent node)
    {
        this.agents.add(node);
    }
    
    /**
     * Add Artefact nodes to the HMN.
     * @param artefacts List of Artefact nodes.
     */
    public void addArtefacts(List<Artefact> artefacts)
    {
        this.artefacts.addAll(artefacts);
    }
    
    /**
     * Add an Artefact node to the HMN.
     * @param node An Artefact object to add to the list of artefacts.
     */
    public void addArtefact(Artefact node)
    {
        this.artefacts.add(node);
    }

    /**
     * Get all the edges in the HMN.
     * @return List of edges.
     */
    public List<Edge> getEdges()
    {
        return edges;
    }

    /**
     * Set the edges of the HMN according to the list provided.
     * This will replace the existing list without calling any clean-up methods. 
     * Consider using the addEdge(..) methods if this is not desirable.
     * @param edges List of Edge objects.
     */
    public void setEdges(List<Edge> edges)
    {
        this.edges = edges;
    }
    
    /**
     * Add edges to the HMN according to the list provided.
     * @param edges List of Edge objects.
     */
    public void addEdges(List<Edge> edges)
    {
        this.edges.addAll(edges);
    }
    
    /**
     * Add an edge to the HMN according to the object provided.
     * @param edge Edge object to add to the HMN.
     */
    public void addEdge(Edge edge)
    {
        this.edges.add(edge);
    }
    
    /**
     * Get the current simulation date and time, which a simulation may use (if synchronised)
     * to set properties such as creation and edit dates for content in an HMN.
     * @return GregorianCalendar instance of the current simulation date/time.
     */
    public GregorianCalendar getCurrentDateTime()
    {
        return currentDateTime;
    }

    /**
     * Set the current simulation date and time.
     * @param currentDateTime GregorianCalendar instance.
     */
    public void setCurrentDateTime(GregorianCalendar currentDateTime)
    {
        this.currentDateTime = currentDateTime;
    }
    
    /**
     * Increment the current simulation date/time.
     * @param seconds The increment in seconds.
     */
    public void incrementCurrentDateTime(int seconds)
    {
        this.currentDateTime.add(GregorianCalendar.SECOND, seconds);
    }
}
