package com.lewis252310.UnknownCube;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Commands implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String inputCmd = (args.length == 0 ? "01" : args[0]);
        if (sender instanceof Player) {
            if (!sender.hasPermission("unknowncube.use" + inputCmd)) {
                sender.sendMessage("沒有權限");
            } else if (args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage(ChatColor.GREEN + "重新加載config.yml");
            } else if (inputCmd.equalsIgnoreCase("01")) {
                sender.sendMessage(ChatColor.GREEN + "開啟GUI-01");
            } else if (args[0].equalsIgnoreCase("02")) {
                sender.sendMessage(ChatColor.GREEN + "開啟GUI-02");
            } else if (args[0].equalsIgnoreCase("03")) {
                sender.sendMessage(ChatColor.GREEN + "開啟GUI-03");
            } else {
                sender.sendMessage(ChatColor.RED + "未知的指令");
            }
        }else {
            sender.sendMessage("該指令只能由玩家使用");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        ArrayList<String> commands = new ArrayList<>();
        commands.add("01");
        commands.add("02");
        commands.add("03");
        if (args.length == 1){
            ArrayList<String> input = new ArrayList<>();
            for (String s : commands){
                if (!s.startsWith(args[0])) continue;
                input.add(s);
            }
            return input;
        }
        return null;
    }
}
