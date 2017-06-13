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
 * An enumeration representing the gender of a Human agent (node), only including 
 * a subset of genders with an 'other' option.
 * Supported genders are: FEMALE, MALE, AGENDER, ANDOGYNE and OTHER.
 * @author Vegard Engen
 */
public enum GenderType implements Serializable
{
    FEMALE("female"), MALE("male"), AGENDER("agender"), ANDOGYNE("androgyne"), OTHER("other");
    
    String name;
    
    private GenderType(String type)
    {
        this.name = type;
    }
    
    public String getName()
    {
        return name;
    }

    @Override
    public String toString ()
    {
        return name;
    }
    
    public static List<String> getAllowedTypes()
    {
        List<String> allowed = new ArrayList<> ();
        allowed.add(FEMALE.name);
        allowed.add(MALE.name);
        allowed.add(AGENDER.name);
        allowed.add(ANDOGYNE.name);
        allowed.add(OTHER.name);
        return allowed;
    }
    
    public static boolean isAllowed (String type)
    {
        for (GenderType inst : values())
        {
            if (inst.name.equals(type))
                return true;
        }
        return false;
    }
    
    public static GenderType fromValue(String v) {
        return valueOf(v.toUpperCase());
    }
	
}
