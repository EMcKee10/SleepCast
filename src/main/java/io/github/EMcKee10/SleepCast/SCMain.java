package io.github.EMcKee10.SleepCast;

import co.aikar.commands.PaperCommandManager;
import com.google.common.collect.ImmutableList;
import org.bukkit.plugin.java.JavaPlugin;

public class SCMain extends JavaPlugin
{
  private static SCMain plugin;
  
  static SCMain getInstance()
  {
    return plugin;
  }
  
  @Override
  public void onEnable()
  {
    plugin = this;
    new SCUtil();
    setupCommands();
    getServer().getPluginManager().registerEvents(new SCListener(), this);
  }
  
  @SuppressWarnings("deprecation")
  private void setupCommands()
  {
    PaperCommandManager manager = new PaperCommandManager(plugin);
    manager.enableUnstableAPI("help");
    manager.getCommandCompletions().registerCompletion("SleepCast", c  -> ImmutableList.of("changemessage", "default","help"));
    manager.registerCommand(new SCExecutor());
  }
  
  
}
