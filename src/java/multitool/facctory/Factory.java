/*
 * Copyright (c) 2007-2009 Concurrent, Inc. All Rights Reserved.
 *
 * Project and contact information: http://www.cascading.org/
 *
 * This file is part of the Cascading project.
 *
 * Cascading is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cascading is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Cascading.  If not, see <http://www.gnu.org/licenses/>.
 */

package multitool.facctory;

import java.util.Map;

/**
 *
 */
public abstract class Factory
  {
  protected String alias;

  protected Factory( String alias )
    {
    this.alias = alias;
    }

  public String getAlias()
    {
    return alias;
    }

  public String[][] getParametersAndUsage()
    {
    String[][] results = new String[getParameters().length][2];

    for( int i = 0; i < getParameters().length; i++ )
      {
      results[ i ][ 0 ] = getAlias() + "." + getParameters()[ i ];
      results[ i ][ 1 ] = getParametersUsage()[ i ];
      }

    return results;
    }

  public abstract String getUsage();

  public abstract String[] getParameters();

  public abstract String[] getParametersUsage();

  protected boolean getBoolean( Map<String, String> params, String key )
    {
    String replace = params.get( key );

    return replace != null && Boolean.parseBoolean( replace );
    }
  }