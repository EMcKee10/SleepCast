package io.github.EMcKee10.SleepCast;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class SCListener implements Listener
{
  private SCMessage messages;
  
  SCListener()
  {
    this.messages = new SCMessage();
  }
  
  @EventHandler
  public void onPlayerBedEnterEvent(PlayerBedEnterEvent event)
  {
    if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK)
    {
      messages.sendMessage(messages.getMessage(event.getPlayer()));
    }
  }
}
