package me.Fupery.ArtMap.Command;

import me.Fupery.ArtMap.ArtMap;
import me.Fupery.ArtMap.Utils.Lang;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CommandHandler implements CommandExecutor {

    private final HashMap<String, Command> commands;

    public CommandHandler() {
        commands = new HashMap<>();
        //Commands go here - note that they are run on an async thread

        commands.put("save", new CommandSave());

        commands.put("delete", new CommandDelete());

        commands.put("preview", new CommandPreview());

        commands.put("backup", new CommandBackup());

        commands.put("restore", new CommandRestore());

        //convenience commands
        commands.put("HELP", new Command(null, "/artmap [HELP]", true) {
            @Override
            public void runCommand(CommandSender sender, String[] args, ReturnMessage msg) {

                if (sender instanceof Player) {
                    ArtMap.getHelpMenu().open(ArtMap.plugin(), (Player) sender);

                } else {
                    ArtMap.getLang().sendArray("CONSOLE_HELP", sender);
                }
            }
        });
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (args.length > 0) {

            if (commands.containsKey(args[0].toLowerCase())) {
                commands.get(args[0].toLowerCase()).runPlayerCommand(sender, args);

            } else {
                sender.sendMessage(ArtMap.getLang().getMsg("HELP"));
            }

        } else {
            commands.get("HELP").runPlayerCommand(sender, args);
        }
        return true;
    }

}