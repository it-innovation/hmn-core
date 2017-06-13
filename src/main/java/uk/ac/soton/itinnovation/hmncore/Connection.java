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

/**
 * A class representing a connection that an Agent (Human or Machine) has to an Edge
 * between the two. Edges are directional, and a Connection from the source Agent to the
 * destination/sink Agent encapsulates properties determining how they may interact with 
 * the destination/sink on the basis of properties like trust.
 * 
 * Similarly, Connection objects associated with the destination Agent encapsulates
 * properties determining how they may behave with regards to the interactions they receive.
 * 
 * This class includes trust and trustworthiness as explicit properties. Their use
 * warrants explanation, as the use of these properties depends on whether the connection
 * is for a SOURCE or SINK node of a directed edge.
 * 
 * From the perspective of a SOURCE node
 *   They have trust in the SINK node
 *   Their trust is based on the trustworthiness of the SINK node
 *   Their trust influences their interactions towards the sink along this edge and connection type, e.g., they may not even chose not to interact
 * From the perspective of the SINK node
 *   They have trust in the SOURCE node
 *   Their trust is based on the trustworthiness of the SOURCE node (as somebody interacting with them)
 *   Their trust influences how they may react to the incoming interaction from the SOURCE node
 * Therefore, if this is a SOURCE connection type
 *   Trust is associated with the SOURCE node
 *   Trustworthiness is associated with the SINK node
 * And, conversely, if this is a SINK connection type
 *   Trust is associated with the SINK node
 *   Trustworthiness is associated with the SOURCE node
 * @see Edge
 * @see Agent
 * @author Vegard Engen
 */
public class Connection implements Serializable
{
    private String connectionID;
    private ConnectionType connectionType;
    private double trust;
    private double trustworthiness;
    private Map<String, Double> properties;

    /**
     * Default constructor, which sets an empty connection ID, the connection type as SOURCE,
     * initialises the Map of properties and the trust parameters to zero.
     */
    public Connection()
    {
        this.connectionID = "";
        this.connectionType = ConnectionType.SOURCE;
        this.trust = 0;
        this.trustworthiness = 0;
        this.properties = new HashMap<>();
    }
    
    /**
     * Calls the default constructor and sets the ID of the connection.
     * @param id The ID/name of the connection.
     */
    public Connection(String id)
    {
        this();
        this.connectionID = id;
    }
    
    /**
     * Calls the default constructor and sets the ID and type for the connection.
     * @param id The ID/name of the connection.
     * @param type The type of the connection (SOURCE or SINK).
     */
    public Connection(String id, ConnectionType type)
    {
        this(id);
        this.connectionType = type;
    }
    
    /**
     * Calls the default constructor and sets the ID and type for the connection,
     * as well as the trust/trustworthiness properties.
     * @param id The ID/name of the connection.
     * @param type The type of the connection (SOURCE or SINK).
     * @param trust The level of trust.
     * @param trustworthiness The level of trustworthiness.
     */
    public Connection (String id, ConnectionType type, double trust, double trustworthiness)
    {
        this(id, type);
        this.trust = trust;
        this.trustworthiness = trustworthiness;
    }

    /**
     * Get the ID/name of the connection.
     * @return String.
     */
    public String getConnectionID()
    {
        return connectionID;
    }

    /**
     * Set the ID/name of the connection.
     * @param connectionID String representing the ID/name of the connection.
     */
    public void setConnectionID(String connectionID)
    {
        this.connectionID = connectionID;
    }

    /**
     * Get the type of connection.
     * @return ConnectionType enum.
     */
    public ConnectionType getConnectionType()
    {
        return connectionType;
    }

    /**
     * Set the type of connection.
     * @param connectionType Enum for the connection type.
     */
    public void setConnectionType(ConnectionType connectionType)
    {
        this.connectionType = connectionType;
    }
    
    /**
     * Get the trust the agent has in the sink node along this connection.
     * @return A float representing the level of trust.
     */
    public double getTrust()
    {
        return trust;
    }

    /**
     * Set the level of trust the agent has in the sink node along this connection.
     * @param trust A float representing the level of trust.
     */
    public void setTrust(double trust)
    {
        this.trust = trust;
    }

    /**
     * Get the trustworthiness the agent represents to the source node along this connection.
     * @return A float representing the level of trust.
     */
    public double getTrustworthiness()
    {
        return trustworthiness;
    }

    /**
     * Set the level of trustworthiness the agent represents to the source node along this connection.
     * @param trustworthiness A float representing the level of trust.
     */
    public void setTrustworthiness(double trustworthiness)
    {
        this.trustworthiness = trustworthiness;
    }

    /**
     * Get the map of properties, in which the key represents the name of the property.
     * @return A Map of numeric (floats) properties in which the key represents the name of the property.
     */
    public Map<String, Double> getProperties()
    {
        return properties;
    }
    
    /**
     * Get the value of a property given the key provided as an argument to this method call.
     * @param key String representing the name of a property.
     * @return The numeric (float) value of a property given the provided name.
     */
    public Double getProperty(String key)
    {
        return this.properties.get(key);
    }

    /**
     * Set bespoke properties for the connection.
     * @param properties Map of properties and their values, in which the Key is the name of each property.
     */
    public void setProperties(Map<String, Double> properties)
    {
        this.properties = properties;
    }
    
    /**
     * Set a bespoke property for the connection.
     * @param key Name of the property.
     * @param value Value of the property.
     */
    public void setProperty(String key, Double value)
    {
        this.properties.put(key, value);
    }
}
