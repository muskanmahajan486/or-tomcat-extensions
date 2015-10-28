/*
 * OpenRemote, the Home of the Digital Home.
 * Copyright 2008-2015, OpenRemote Inc.
 *
 * See the contributors.txt file in the distribution for a
 * full listing of individual contributors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openremote.tomcat.realm;

import org.apache.catalina.realm.DataSourceRealm;

import java.security.Principal;

/**
 * Extension to the standard DataSourceRealm implementation for Tomcat
 * providing compatibility with Legacy Beehive database schema.
 *
 * This realm ensures that the credentials used to compare with DB information is appropriate,
 * that is in the format 'password{username}'.
 *
 * Passwords in Beehive DB are usually hashed using md5, so the digest="md5" must be used
 * on the realm configuration.
 *
 * @author <a href="mailto:eric@openremote.org">Eric Bariaux</a>
 */
public class LegacyBeehiveDataSourceRealm extends DataSourceRealm
{

  @Override
  public Principal authenticate(String username, String credentials)
  {
    return super.authenticate(username, credentials + "{" + username + "}");
  }
}
