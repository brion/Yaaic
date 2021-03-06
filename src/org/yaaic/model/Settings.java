/*
Yaaic - Yet Another Android IRC Client

Copyright 2009-2010 Sebastian Kaspari

This file is part of Yaaic.

Yaaic is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Yaaic is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Yaaic.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.yaaic.model;

import org.yaaic.R;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

/**
 * The settings class is a helper class to access the different preferences via
 * small and simple methods.
 * 
 * Note: As this class carries a Context instace as private member, instances of
 * 		 this class should be thrown away not later than when the Context should
 * 		 be gone. Otherwise this could leak memory. 
 * 
 * @author Sebastian Kaspari <sebastian@yaaic.org>
  */
public class Settings
{
	private SharedPreferences preferences;
	private Resources resources;
	
	/**
	 * Create a new Settings instance
	 * 
	 * @param context
	 */
	public Settings(Context context)
	{
		this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
		this.resources = context.getApplicationContext().getResources();
	}
	
	/**
	 * Prefix all messages with a timestamp?
	 * 
	 * @return
	 */
	public boolean showTimestamp()
	{
		return preferences.getBoolean(
			resources.getString(R.string.key_show_timestamp),
			Boolean.parseBoolean(resources.getString(R.string.default_show_timestamp))
		);
	}
	
	/**
	 * Show icons to highlight special events
	 * 
	 * @return
	 */
	public boolean showIcons()
	{
		return preferences.getBoolean(
				
			resources.getString(R.string.key_show_icons),
			Boolean.parseBoolean(resources.getString(R.string.default_show_icons))
		);
	}
	
	/**
	 * Show colors to highlight special events?
	 * 
	 * @return
	 */
	public boolean showColors()
	{
		return preferences.getBoolean(
			resources.getString(R.string.key_show_colors),
			Boolean.parseBoolean(resources.getString(R.string.default_show_colors))
		);
	}
	
	/**
	 * Use 24 hour format for timestamps?
	 * 
	 * @return
	 */
	public boolean use24hFormat()
	{
		return preferences.getBoolean(
			resources.getString(R.string.key_24h_format),
			Boolean.parseBoolean(resources.getString(R.string.default_24h_format))
		);
	}
	
	/**
	 * Is reconnect on disconnect enabled?
	 * 
	 * @return 
	 */
	public boolean isReconnectEnabled()
	{
		return preferences.getBoolean(
			resources.getString(R.string.key_reconnect),
			Boolean.parseBoolean(resources.getString(R.string.default_reconnect))
		);
	}
	
	/**
	 * Get the quit message
	 * 
	 * @return The message to display when the user disconnects
	 */
	public String getQuitMessage()
	{
		return preferences.getString(
			resources.getString(R.string.key_quitmessage),
			resources.getString(R.string.default_quitmessage)
		);
	}
}
