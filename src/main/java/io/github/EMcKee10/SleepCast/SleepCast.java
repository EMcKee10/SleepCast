package io.github.EMcKee10.SleepCast;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class SleepCast extends JavaPlugin
{
  
  private File messageFile = new File(getDataFolder(), "messages.yml");
  private FileConfiguration messageConfig = YamlConfiguration.loadConfiguration(messageFile);
  
  
  
  @Override
  public void onDisable()
  {
  getServer().getPluginManager().registerEvents(new SleepListener(this), this);
  this.getCommand("changemessage").setExecutor(new SleepExecutor(this));
  this.getCommand("default").setExecutor(new SleepExecutor(this));
  }
  
  @Override
  public void onEnable()
  {
  if(!messageFile.exists())
  {
    saveResource("message.yml", false);
  }
  
  }
  
  public FileConfiguration getMessagesConfig()
  {
    return messageConfig;
  }
  public File getMessagesFile()
  {
    return messageFile;
  }
}
