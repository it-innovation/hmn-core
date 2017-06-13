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
//      Created Date :          2017-02-03
//      Created for Project :   HUMANE
//
/////////////////////////////////////////////////////////////////////////
package uk.ac.soton.itinnovation.hmncore;

import java.io.Serializable;

/**
 * A class encapsulating statistics for an Edge, which in the Edge class may be
 * distinguished on the bases of each type of Connection.
 * @see Edge
 * @see Connection
 * @author Vegard Engen
 */
public class EdgeStats implements Serializable
{
    private int interactionStrength;
    private int numInteractions;
    
    /**
     * Default constructor initialising the variables of the object (to zero).
     */
    public EdgeStats()
    {
        interactionStrength = 0;
        numInteractions = 0;
    }

    /**
     * Get the interaction strength.
     * @return Interaction strength value.
     */
    public int getInteractionStrength()
    {
        return interactionStrength;
    }

    /**
     * Set the interaction strength.
     * @param interactionStrength Interaction strength value.
     */
    public void setInteractionStrength(int interactionStrength)
    {
        this.interactionStrength = interactionStrength;
    }

    /**
     * Get the number of interactions.
     * @return Value for the number of interactions.
     */
    public int getNumInteractions()
    {
        return numInteractions;
    }

    /**
     * Set the number of interactions.
     * @param numInteractions Value for the number of interactions.
     */
    public void setNumInteractions(int numInteractions)
    {
        this.numInteractions = numInteractions;
    }
    
    /**
     * Add an interaction (increments by 1).
     */
    public void addInteraction()
    {
        this.numInteractions++;
    }
    
    /**
     * Add interactions by some variable amount.
     * @param i The number of interactions to add.
     */
    public void addInteractions(int i)
    {
        this.numInteractions = this.numInteractions + i;
    }
}
