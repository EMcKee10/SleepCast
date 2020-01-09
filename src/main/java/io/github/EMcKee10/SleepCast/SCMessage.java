package io.github.EMcKee10.SleepCast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

class SCMessage
{
  private final SCUtil util;
  
  SCMessage()
  {
    this.util = SCUtil.getInstance();
  }
  String getMessage(Player player)
  {
    String defaultMessage;
    defaultMessage = util.getMessagesConfig().getString("Messages.Default");
    if (defaultMessage != null && defaultMessage.contains("[playername]")) {
      defaultMessage = SCPlaceHolders.attachPlayerName(player, defaultMessage);
    }
  
    String custommessage = util.getMessagesConfig().getString("Messages.Custom");
  
    if (custommessage != null && custommessage.contains("[playername]")) {
      custommessage = SCPlaceHolders.attachPlayerName(player, custommessage);
    }
  
    if (defaultMessage != null) {
      defaultMessage = ChatColor.translateAlternateColorCodes('&', defaultMessage);
    }
    if (custommessage != null) {
      custommessage = ChatColor.translateAlternateColorCodes('&', custommessage);
    }
  
    String message = "";
    if (custommessage != null) {
      if (custommessage.equals(""))
        message = defaultMessage;
      else
        message = custommessage;
    }
  
    return message;
  }
  
  void sendMessage(String message)
  {
    for (Player p : Bukkit.getOnlinePlayers())
      p.sendMessage(message);
  }
}
