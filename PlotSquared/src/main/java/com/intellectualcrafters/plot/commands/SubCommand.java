/*
 * Copyright (c) IntellectualCrafters - 2014. You are not allowed to distribute
 * and/or monetize any of our intellectual property. IntellectualCrafters is not
 * affiliated with Mojang AB. Minecraft is a trademark of Mojang AB.
 * 
 * >> File = SubCommand.java >> Generated by: Citymonstret at 2014-08-09 01:42
 */

package com.intellectualcrafters.plot.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.intellectualcrafters.plot.C;
import com.intellectualcrafters.plot.PlayerFunctions;

/**
 * SubCommand class
 *
 * @author Citymonstret
 */
public abstract class SubCommand {
	public boolean isPlayer;
	/**
	 * Command
	 */
	public String cmd;
	/**
	 * Permission node
	 */
	public CommandPermission permission;
	/**
	 * Simple description
	 */
	public String description;
	/**
	 * Alias
	 */
	public String alias;

	/**
	 * Command usage
	 */
	public String usage;

	public CommandCategory category;

	/**
	 * @param cmd
	 *            Command /plot {cmd} <-- That!
	 * @param permission
	 *            Permission Node
	 * @param description
	 *            Simple description
	 * @param usage
	 *            Usage description: /plot command {args...}
	 * @param alias
	 *            Command alias
	 * @param category
	 *            CommandCategory. Pick whichever closests to what you want.
	 */
	public SubCommand(String cmd, String permission, String description, String usage, String alias,
			CommandCategory category, boolean isPlayer) {
		this.cmd = cmd;
		this.permission = new CommandPermission(permission);
		this.description = description;
		this.alias = alias;
		this.usage = usage;
		this.category = category;
		this.isPlayer = isPlayer;
	}

	/**
	 * @param command
	 *            Command /plot {cmd} <-- That!
	 * @param description
	 *            Simple description
	 * @param usage
	 *            Usage description: /plot command {args...}
	 * @param category
	 *            CommandCategory. Pick whichever closests to what you want.
	 */
	public SubCommand(Command command, String description, String usage, CommandCategory category, boolean isPlayer) {
		this.cmd = command.getCommand();
		this.permission = command.getPermission();
		this.alias = command.getAlias();
		this.description = description;
		this.usage = usage;
		this.category = category;
		this.isPlayer = isPlayer;
	}

	/**
	 * Execute.
	 * 
	 * @param plr
	 *            executor
	 * @param args
	 *            arguments
	 * @return true on success, false on failure
	 */
	public abstract boolean execute(Player plr, String... args);

	public void executeConsole(String... args) {
		this.execute(null, args);
	}

	/**
	 * Send a message
	 * 
	 * @param plr
	 * @param c
	 * @param args
	 */
	public void sendMessage(Player plr, C c, String... args) {
		PlayerFunctions.sendMessage(plr, c, args);
	}

	public enum CommandCategory {
		CLAIMING("Claiming"),
		TELEPORT("Teleportation"),
		ACTIONS("Actions"),
		INFO("Information");
		private String name;

		CommandCategory(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
}