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
    Player player = event.getPlayer();
    
    String defaultMessage = sleepPlugin.getMessagesConfig().getString("Messages.Default");
    System.out.println(defaultMessage);
    if(defaultMessage.contains("[playername]"))
    {
      attachPlayername(player, defaultMessage);
    }
    
    String custommessage = sleepPlugin.getMessagesConfig().getString("Messages.Custom");
  
    if(custommessage.contains("[playername]"))
    {
      attachPlayername(player,custommessage);
    }
    
    defaultMessage = ChatColor.translateAlternateColorCodes('&', defaultMessage);
    custommessage = ChatColor.translateAlternateColorCodes('&', custommessage);
    
    if(custommessage.equals(""))
    {
      Bukkit.broadcastMessage(defaultMessage);
    }
    else
      Bukkit.broadcastMessage(custommessage);
  }
  
  private String attachPlayername(Player player, String message)
  {
    do
    {
      message = message.replace("[playername]",player.getName());
    } while(message.contains("[playername]"));
    
    return message;
  }
  
  
}
