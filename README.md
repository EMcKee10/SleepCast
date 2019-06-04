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
## -permissions-
special_reservation.specialbypass: <br />
    description: permission to allow a user into the reserved slots <br />
    
  special_reservation.staffbypass: <br />
    description: permission to allow staff to bypass server slot limit <br />
    
  special_reservation.showonline: <br />
    description: permission to check players with staff bypass online <br />
    default: op <br />
    
  special_reservation.reserve: <br />
    description: permission for changing number of reserved slots <br />
    default: op <br />
    
  special_reservation.rstoggle: <br />
    description: permission for toggling reserved slots <br />
    default: op <br />
    
  special_reservation.changeFullMessage: <br />
    description: permission to change Full Messages <br />
    default: op <br />
    
  special_reservation.reloadsr: <br />
    default: op <br />
    
---
## -Commands-

### /reserve:
description: Change the number of reserved slots. <br />
permission: special_reservation.reserve <br />

### /rstoggle:
description: Toggles reserved slots <br />
permission: special_reservation.rstoggle <br />

### /SpecialFullMessage:
description: Changes special full message, use & for colors <br />
aliases: SMessage<br />
permission: special_reservation.changeFullMessage <br />

### /RegularFullMessage:
description: Changes regular full message, use & for colors <br />
aliases: RMessage <br />
permission: special_reservation.changeFullMessage <br />

### /SpecialOnline:
description: Gives you the names and a count of all players with special bypass <br />
permission: special_reservation.showonline <br />

### /StaffOnline:
description: Gives you the names and a count of all players with staff bypass <br />
permission: special_reservation.showonline <br />

### /RegularOnline:
description: Gives you the names and a count of all players with no bypasses <br />
permission: special_reservation.showonline <br />

### /ReloadSR:
description: Reloads the plugin with the correct number of players with specific permissions. <br />
permission: special_reservation.reloadsr <br />

---
## -How to install-
1. Click the Release tab on this page in GitHub
2. Find the Latest release version, and under Assets at the bottom, click on the SpecialReservation-x.x.x.jar
3. Place downloaded .jar file into your server's plugins folder
4. Restart your server. 

### Enjoy!


