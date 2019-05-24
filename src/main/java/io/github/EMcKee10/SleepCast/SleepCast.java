package io.github.EMcKee10.SleepCast;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SleepCast extends JavaPlugin
{
  private File messageFile;
  private FileConfiguration messageConfig;

  @Override
  public void onDisable()
  {
  }
  
  @Override
  public void onEnable()
  {
    createCustomConfig();

    getServer().getPluginManager().registerEvents(new SleepListener(this), this);
    Objects.requireNonNull(this.getCommand("changemessage")).setExecutor(new SleepExecutor(this));
    Objects.requireNonNull(this.getCommand("default")).setExecutor(new SleepExecutor(this));
  }

  private void createCustomConfig()
  {

    messageFile = new File(this.getDataFolder(), "message.yml");

    if (!messageFile.exists())
    {
      messageFile.getParentFile().mkdirs();
      saveResource("message.yml", false);
    }

    messageConfig = new YamlConfiguration();
    try
    {
      messageConfig.load(messageFile);
    } catch (IOException | InvalidConfigurationException e)
    {
      System.out.println("There was a problem loading your yml file");
      e.printStackTrace();
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
