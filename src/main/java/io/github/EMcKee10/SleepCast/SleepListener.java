package io.github.EMcKee10.SleepCast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class SleepListener implements Listener
{

  public SleepCast sleepPlugin;

  public SleepListener(SleepCast sleepPlugin)
  {
    this.sleepPlugin = sleepPlugin;
  }
  
  @EventHandler
  public void onPlayerBedEnterEvent(PlayerBedEnterEvent event)
  {
    if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK)
    {
      Player player = event.getPlayer();

      String defaultMessage = sleepPlugin.getMessagesConfig().getString("Messages.Default");
      if (defaultMessage.contains("[playername]"))
      {
        defaultMessage = attachPlayerName(player, defaultMessage);
      }

      String custommessage = sleepPlugin.getMessagesConfig().getString("Messages.Custom");

      if (custommessage.contains("[playername]"))
      {
        custommessage = attachPlayerName(player, custommessage);
      }

      defaultMessage = ChatColor.translateAlternateColorCodes('&', defaultMessage);
      custommessage = ChatColor.translateAlternateColorCodes('&', custommessage);

      String message;
      if (custommessage.equals(""))
        message = defaultMessage;
      else
        message = custommessage;

      for (Player p : Bukkit.getOnlinePlayers())
        p.sendMessage(message);
    }
  }

  private String attachPlayerName(Player player, String message)
  {
    do
    {
      message = message.replace("[playername]", player.getName());
    } while(message.contains("[playername]"));
    
    return message;
  }
  
  
}
