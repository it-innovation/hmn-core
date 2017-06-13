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
 * An abstract class representing a Human in the HMN and their core properties.
 * @author Vegard Engen
 */
public abstract class Human extends Agent implements Serializable
{
    protected int age;
    protected GenderType gender;
    protected SexualOrientationType sexualOrientation;
    protected CultureType culture; // collective vs individualistic
    protected double selfEfficacy;
    protected double computerSelfEfficacy;
    protected double trust;
    protected int reputation;

    /**
     * Default constructor, initialises all the properties of the class.
     */
    public Human()
    {
        this.age = 0;
        this.gender = GenderType.OTHER;
        this.sexualOrientation = SexualOrientationType.OTHER;
        this.culture = CultureType.OTHER;
        this.selfEfficacy = 0;
        this.computerSelfEfficacy = 0;
        this.trust = 0;
        this.reputation = 0;
    }

    /**
     * Get the age of the human agent.
     * @return Integer representing the age in years.
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Set the age of the human agent.
     * @param age Integer representing the age in years.
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * Get the gender of the human agent.
     * @return GenderType enum.
     */
    public GenderType getGender()
    {
        return gender;
    }

    /**
     * Set the gender of the human agent.
     * @param gender GenderType enum.
     */
    public void setGender(GenderType gender)
    {
        this.gender = gender;
    }
    
    /**
     * Get the sexual orientation of the human agent.
     * @return SexualOrientationType enum.
     */
    public SexualOrientationType getSexualOrientation()
    {
        return sexualOrientation;
    }

    /**
     * Set the sexual orientation of the human agent.
     * @param sexualOrientation SexualOrientationType enum.
     */
    public void setSexualOrientation(SexualOrientationType sexualOrientation)
    {
        this.sexualOrientation = sexualOrientation;
    }

    /**
     * Get the reputation of the human agent.
     * @return Integer representing a reputation value for the agent.
     */
    public int getReputation()
    {
        return reputation;
    }

    /**
     * Set the reputation of the human agent.
     * @param reputation Integer representing a reputation value for the agent.
     */
    public void setReputation(int reputation)
    {
        this.reputation = reputation;
    }

    /**
     * Get the general (propensity to) trust value for the human agent.
     * @return Float representing a trust value for the agent.
     */
    public double getTrust()
    {
        return trust;
    }

    /**
     * Set the general (propensity to) trust value for the human agent.
     * @param trust Float representing a trust value for the agent.
     */
    public void setTrust(double trust)
    {
        this.trust = trust;
    }

    /**
     * Get the culture type of the HUMAN agent.
     * @return CultureType enum.
     */
    public CultureType getCulture()
    {
        return culture;
    }

    /**
     * Set the culture type of the HUMAN agent.
     * @param culture CultureType enum.
     */
    public void setCulture(CultureType culture)
    {
        this.culture = culture;
    }

    /**
     * Get the self-efficacy of the human agent. That is, the belief that they
     * are able to achieve their goals.
     * @return A float representing a self-efficacy value for the agent.
     */
    public double getSelfEfficacy()
    {
        return selfEfficacy;
    }

    /**
     * Set the self-efficacy of the human agent.That is, the belief that they
     * are able to achieve their goals.
     * @param selfEfficacy A float representing a self-efficacy value for the agent.
     */
    public void setSelfEfficacy(double selfEfficacy)
    {
        this.selfEfficacy = selfEfficacy;
    }

    /**
     * Get the computer-mediated self-efficacy of the human agent. That is, the belief that they
     * are able to achieve their goals using the machines in the HMN.
     * @return A float representing a computer-mediated self-efficacy value for the agent.
     */
    public double getComputerSelfEfficacy()
    {
        return computerSelfEfficacy;
    }

    /**
     * Get the computer-mediated self-efficacy of the human agent. That is, the belief that they
     * are able to achieve their goals using the machines in the HMN.
     * @param computerSelfEfficacy A float representing a computer-mediated self-efficacy value for the agent.
     */
    public void setComputerSelfEfficacy(double computerSelfEfficacy)
    {
        this.computerSelfEfficacy = computerSelfEfficacy;
    }
}
