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

/**
 * An abstract class representing an Agent in the HMN. At the core level, this can
 * be either a Human or a Machine.
 * @see Human
 * @see Machine
 * @author Vegard Engen
 */
public abstract class Agent extends Node implements Serializable
{
    /**
     * Default constructor.
     */
    public Agent()
    {
	    
    }
    
    /**
     * Abstract method that should be implemented by actors in a simulated
     * environment for a HMN, which should be invoked during the course of a simulation.
     * @throws Exception For any errors.
     */
    public abstract void takeAction() throws Exception;
}
