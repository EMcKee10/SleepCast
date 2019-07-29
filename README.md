# SleepCast
## Latest Release: v1.0.0

**_SleepCast_** sends a default or custom message to all players on the server that a person has entered bed and is sleeping. Useful for notifying others that they too should go to bed.

### -Custom messaging-
Allows a player or console to set custom bed entering message with /changemessage, /cmsg, or /changem<br />
_Example:_ /changemessage Someone has entered a bed!

### -Tags-
Add [playername] allows a person name to be placed within the message<br />
_Example:_ Player [playername] just jumped into bed!<br />
_Result (given a player named JohnDoe enters a bed):_ Player JohnDoe just jumped into bed!

### -Default-
Use the /default command to set the sleep message to the default message for SleepCast<br />
_Default message:_ &d[playername] is sleeping in a bed

### -Color-
Add a splash of color by using ampersand with Minecraft's color code<br />
_Example:_ &1[playername] is in bed now! will make the message appear blue

---

 ## -Permission-
permission: SleepCast.ChangeMessage<br />
description: Change message a player sees when going to bed.

permission: SleepCast.Default  
description: Change message to default §d[playername] is sleeping in a bed

---
## -Commands
### /changemessage [Message]
Changes the message the players on the server see when someone sleeps in a bed. <br />
Try adding tags to create a unique message. <br />

### /default
Change message to default §d[playername] is sleeping in a bed <br /> 

---
## -How to install-
1. Click the Release tab on this page in GitHub
2. Find the Latest release version, and under Assets at the bottom, click on the SleepCast-x.x.x.jar
3. Place downloaded .jar file into your server's plugins folder
4. Restart your server. 

### Enjoy!


