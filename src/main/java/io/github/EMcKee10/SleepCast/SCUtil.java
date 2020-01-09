package io.github.EMcKee10.SleepCast;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

class SCUtil
{
  private static SCUtil util;
  private SCMain plugin;
  private File messageFile;
  private FileConfiguration messageConfig;
  
  SCUtil()
  {
    plugin = SCMain.getInstance();
    util = this;
    reloadConfig();
  }
  
  static SCUtil getInstance()
  {
    return util;
  }
  
  private void createCustomConfig()
  {
    
    messageFile = new File(plugin.getDataFolder(), "message.yml");
    
    if (!messageFile.exists())
    {
      messageFile.getParentFile().mkdirs();
      plugin.saveResource("message.yml", false);
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
  
  private void reloadConfig(){ createCustomConfig();}
  
  FileConfiguration getMessagesConfig()
  {
    return messageConfig;
  }
  
  File getMessagesFile()
  {
    return messageFile;
  }
  
}
