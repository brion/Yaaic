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
package org.yaaic.command.handler;

import org.yaaic.command.BaseHandler;
import org.yaaic.exception.CommandException;
import org.yaaic.irc.IRCService;
import org.yaaic.model.Conversation;
import org.yaaic.model.Server;

/**
 * Command: /kick <nickname>
 * 
 * Kicks a user from the current channel
 * 
 * @author Sebastian Kaspari <sebastian@yaaic.org>
 */
public class KickHandler extends BaseHandler
{
	/**
	 * Execute /kick
	 */
	@Override
	public void execute(String[] params, Server server, Conversation conversation, IRCService service) throws CommandException 
	{
		if (conversation.getType() != Conversation.TYPE_CHANNEL) {
			throw new CommandException("Only usable from within a channel");
		}
		
		if (params.length == 2) {
			service.getConnection(server.getId()).kick(conversation.getName(), params[1]);
		} else {
			throw new CommandException("Invalid number of params");
		}
	}
	
	/**
	 * Usage of /kick
	 */
	@Override
	public String getUsage()
	{
		return "/kick <nickname>";
	}

	/**
	 * Description of /kick
	 */
	@Override
	public String getDescription()
	{
		return "Kicks a user";
	}
}
