package io.github.EMcKee10.SleepCast;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SleepExecutor implements CommandExecutor
{
  private final SleepCast sleepCast;

  SleepExecutor(SleepCast sleepCast)
  {
    this.sleepCast = sleepCast;
  }
  
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if(sender instanceof Player)
    {
      Player player = (Player)sender;
    }

    if (command.getName().equalsIgnoreCase("changemessage"))
    {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Incorrect command usage, try /join <message>.");
      }
      else {
        StringBuilder builder = new StringBuilder();
        for (String arg : args) {
          builder.append(" ").append(arg);
        }
        String message = builder.toString().trim();
        sleepCast.getMessagesConfig().set("Messages.Custom", message);
        try
        {
          sleepCast.getMessagesConfig().save(sleepCast.getMessagesFile());
          sender.sendMessage(ChatColor.GREEN + "The Message was successfully set to " + ChatColor.YELLOW + message);
          return true;
        } catch(IOException e) {
          sender.sendMessage(ChatColor.RED + "An error has occurred while trying to set the message!");
        }
        
      }
    } else if (command.getName().equalsIgnoreCase("default"))
    {
      sleepCast.getMessagesConfig().set("Messages.Custom", "");
      try
      {
        sleepCast.getMessagesConfig().save(sleepCast.getMessagesFile());
        sender.sendMessage(ChatColor.GREEN + "The Message was successfully set to the default message");
        return true;
      } catch(IOException e) {
        sender.sendMessage(ChatColor.RED + "An error has occurred while trying to set the message!");
      }
  
    }
    
    return false;
  }
}
