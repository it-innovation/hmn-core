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
import java.util.Date;

/**
 * An abstract class reflecting an Artefact in the HMN, which is a type of node that
 * does not have agency. That could be a file, a forum post, a Tweet, an email, etc.
 * @author Vegard Engen
 */
public class Artefact extends Node implements Serializable
{
    // private String artefactID; // use nodeID
    protected Agent creator;
    protected Date creationDate;

    /**
     * Default constructor, which does nothing.
     */
    public Artefact() { }
    
    /**
     * Constructor to set the node who created this artefact and the date this occurred.
     * @param id The ID of the artefact.
     */
    public Artefact(String id)
    {
        this.nodeID = id;
    }
    
    /**
     * Constructor to set the node who created this artefact and the date this occurred.
     * @param a Agent object for the creator of this artefact.
     * @param d The date for which the artefact was created.
     */
    public Artefact(Agent a, Date d)
    {
        this.creator = a;
        this.creationDate = d;
    }
    
    /**
     * Constructor to set the node who created this artefact and the date this occurred.
     * @param id The ID of the artefact.
     * @param a Agent object for the creator of this artefact.
     * @param d The date for which the artefact was created.
     */
    public Artefact(String id, Agent a, Date d)
    {
        this.nodeID = id;
        this.creator = a;
        this.creationDate = d;
    }

    /**
     * Get the creator (agent) of this artefact.
     * @return Agent object.
     */
    public Agent getCreator()
    {
        return creator;
    }

    /**
     * Set the creator (agent) of this artefact.
     * @param creator Agent object.
     */
    public void setCreator(Agent creator)
    {
        this.creator = creator;
    }
    
    /**
     * Get the date for which this artefact was created.
     * @return Date object.
     */
    public Date getCreationDate()
    {
        return creationDate;
    }

    /**
     * Set the date this artefact was created.
     * @param creationDate Date object.
     */
    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }    
}
