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
//      Created Date :          2017-02-09
//      Created for Project :   HUMANE
//
/////////////////////////////////////////////////////////////////////////
package uk.ac.soton.itinnovation.hmncore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * An enum representing a subset of sexual orientation of human nodes, with an
 * 'other' option for orientations not included here.
 * Supported values are: HETEROSEXUAL, BISEXUAL, GAY, LESBIAN, ASEXUAL and OTHER.
 * @author Vegard Engen
 */
public enum SexualOrientationType implements Serializable
{
    HETEROSEXUAL("heterosexual"), BISEXUAL("bisexual"), GAY("gay"), LESBIAN("lesbian"), ASEXUAL("asexual"), OTHER("other");
    
    String name;
    
    private SexualOrientationType(String type)
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
        allowed.add(HETEROSEXUAL.name);
        allowed.add(BISEXUAL.name);
        allowed.add(GAY.name);
        allowed.add(LESBIAN.name);
        allowed.add(ASEXUAL.name);
        allowed.add(OTHER.name);
        return allowed;
    }
    
    public static boolean isAllowed (String type)
    {
        for (SexualOrientationType inst : values())
        {
            if (inst.name.equals(type))
                return true;
        }
        return false;
    }
    
    public static SexualOrientationType fromValue(String v) {
        return valueOf(v.toUpperCase());
    }
}
