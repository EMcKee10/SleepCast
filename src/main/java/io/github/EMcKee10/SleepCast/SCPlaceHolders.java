package io.github.EMcKee10.SleepCast;

import org.bukkit.entity.Player;

class SCPlaceHolders
{
  
  static String attachPlayerName(Player player, String message)
  {
    do
    {
      message = message.replace("[playername]", player.getName());
    } while(message.contains("[playername]"));
    
    return message;
  }
}
