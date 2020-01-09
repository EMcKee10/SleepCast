package io.github.EMcKee10.SleepCast;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.*;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

import java.io.IOException;

@CommandAlias("SleepCast")
@Description("Commands for SleepCast")
public class SCExecutor extends BaseCommand
{
  private final SCUtil util;
  
  SCExecutor()
  {
    this.util = SCUtil.getInstance();
  }
  
  @Subcommand("default")
  @CommandPermission("sleepcast.default")
  @CommandCompletion("@SleepCast")
  @Description("Change message to default §d[playername] is sleeping in a bed")
  public boolean onDefaultCommand(CommandSender sender)
  {
    boolean result;
    
    util.getMessagesConfig().set("Messages.Custom", "");
    String message = util.getMessagesConfig().getString("Messages.Default");
    if (message != null) {
      message = ChatColor.translateAlternateColorCodes('&', message);
    }
    try
    {
      util.getMessagesConfig().save(util.getMessagesFile());
      sender.sendMessage(ChatColor.GREEN + "The Message was successfully set to the default message");
      sender.sendMessage(ChatColor.GREEN + "Default Message: " + message);
      result = true;
    } catch(IOException e) {
      sender.sendMessage(ChatColor.RED + "An error has occurred while trying to set the message.");
      result = false;
    }
    return result;
  }
  
  @Subcommand("changemessage")
  @CommandPermission("sleepcast.changemessage")
  @CommandCompletion("@SleepCast")
  @Description("Change message a player sees when going to bed.")
  public boolean onChangeMessageCommand(CommandSender sender, String[] message)
  {
    boolean result;
    String customMessage;
    StringBuilder builder = new StringBuilder();
    
    for (String arg : message) {
      builder.append(" ").append(arg);
    }
    customMessage = builder.toString().trim();
    util.getMessagesConfig().set("Messages.Custom", customMessage);
    try
    {
      util.getMessagesConfig().save(util.getMessagesFile());
      customMessage = ChatColor.translateAlternateColorCodes('&', customMessage);
      sender.sendMessage(ChatColor.GREEN + "The Message was successfully set to: " + customMessage);
      result = true;
    } catch(IOException e) {
      sender.sendMessage(ChatColor.RED + "An error has occurred while trying to set the message.");
      result = false;
    }
    
    return result;
  }
  
  @Subcommand("help")
  @CommandPermission("sleepcast.help")
  @CatchUnknown
  @Default
  @Description("Shows help message")
  public void onHelp(CommandHelp help) {
    help.showHelp();
  }
}
