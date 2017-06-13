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
 * An abstract class representing a Machine in the HMN and its core properties.
 * @author Vegard Engen
 */
public abstract class Machine extends Agent implements Serializable
{
    protected double capacity;
    protected double availability;
    protected double reliability;
    protected double responsiveness;
    protected double throughput;
    protected double utilisation;

    /**
     * Default constructor, initialising all the properties of the class.
     */
    public Machine()
    {
        this.capacity = 0;
        this.availability = 0;
        this.reliability = 0;
        this.responsiveness = 0;
        this.throughput = 0;
        this.utilisation = 0;
    }

    /**
     * Get the capacity of the machine agent.
     * @return A float representing the capacity of the machine agent.
     */
    public double getCapacity()
    {
        return capacity;
    }

    /**
     * Get the capacity of the machine agent.
     * @param capacity A float representing the capacity of the machine agent.
     */
    public void setCapacity(double capacity)
    {
        this.capacity = capacity;
    }

    /**
     * Get the availability of the machine agent.
     * @return A float representing the availability of the machine agent.
     */
    public double getAvailability()
    {
        return availability;
    }

    /**
     * Set the availability of the machine agent.
     * @param availability A float representing the availability of the machine agent.
     */
    public void setAvailability(double availability)
    {
        this.availability = availability;
    }

    /**
     * Get the reliability of the machine agent.
     * @return A float representing the reliability of the machine agent.
     */
    public double getReliability()
    {
        return reliability;
    }

    /**
     * Set the reliability of the machine agent.
     * @param reliability A float representing the reliability of the machine agent.
     */
    public void setReliability(double reliability)
    {
        this.reliability = reliability;
    }

    /**
     * Get the responsiveness of the machine agent.
     * @return A float representing the responsiveness of the machine agent.
     */
    public double getResponsiveness()
    {
        return responsiveness;
    }

    /**
     * Set the responsiveness of the machine agent.
     * @param responsiveness A float representing the responsiveness of the machine agent.
     */
    public void setResponsiveness(double responsiveness)
    {
        this.responsiveness = responsiveness;
    }

    /**
     * Get the throughput of the machine agent.
     * @return A float representing the throughput of the machine agent.
     */
    public double getThroughput()
    {
        return throughput;
    }

    /**
     * Set the throughput of the machine agent.
     * @param throughput A float representing the throughput of the machine agent.
     */
    public void setThroughput(double throughput)
    {
        this.throughput = throughput;
    }

    /**
     * Get the utilisation of the machine agent.
     * @return A float representing the utilisation of the machine agent.
     */
    public double getUtilisation()
    {
        return utilisation;
    }

    /**
     * Set the utilisation of the machine agent.
     * @param utilisation A float representing the utilisation of the machine agent.
     */
    public void setUtilisation(double utilisation)
    {
        this.utilisation = utilisation;
    }

    
}
