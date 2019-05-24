package io.github.EMcKee10.SleepCast;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public class SleepCast extends JavaPlugin
{
  
  private File messageFile = new File(getDataFolder(), "messages.yml");
  private FileConfiguration messageConfig = YamlConfiguration.loadConfiguration(messageFile);
  
  
  
  @Override
  public void onDisable()
  {
  }
  
  @Override
  public void onEnable()
  {
  if(!messageFile.exists())
  {
    saveResource("message.yml", false);
  }
    getServer().getPluginManager().registerEvents(new SleepListener(this), this);
    Objects.requireNonNull(this.getCommand("changemessage")).setExecutor(new SleepExecutor(this));
    Objects.requireNonNull(this.getCommand("default")).setExecutor(new SleepExecutor(this));
  }

  FileConfiguration getMessagesConfig()
  {
    return messageConfig;
  }

  File getMessagesFile()
  {
    return messageFile;
  }
}
