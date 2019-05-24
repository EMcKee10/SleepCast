package io.github.EMcKee10.SleepCast;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public class SleepCast extends JavaPlugin
{

  public File messageFile = new File(getDataFolder(), "messages.yml");
  public FileConfiguration messageConfig = YamlConfiguration.loadConfiguration(messageFile);
  
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

  public FileConfiguration getMessagesConfig()
  {
    return messageConfig;
  }

  public File getMessagesFile()
  {
    return messageFile;
  }
}
