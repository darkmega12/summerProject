summerProject
=============
SETTING UP GITHUB IN ECLIPSE


/* NOTE: in the event that you have made changes to the 

project (after uploading it in the group) without setting this 

up yet, send me the changes you've made.*/

***Necessary files/things to do ***
EGIT (If your eclipse doesn't have it yet): 

http://download.eclipse.org/egit/updates

GITHUB: github.com 
//register and download github

GIT: http://git-scm.com/download/win 
//in case github doesn't have this with it which is unlikely



INSTRUCTION FOR SET UP AND FOR DOWNLOADING THE FILE

0. Download necessary files and install.
1. In File Explorer, Right Click Computer and select properties
2. Select Advanced System Settings
3. In Advanced tab, select Environment Variables
4. Add a new user variable with "HOME" as variable name and File path of your account (eg C:\Users\Kiel) as value 
5. Open Eclipse
6. Go to windows tab and select preferences
7. go to general - > Network Connections - > SSH2
8. select key management
9. Click on generate dsa key and send me the generated key.
10. Save private key in the default directory and close window.
11. Select the File tab and click on import...
12. select Git and choose clone uri for repository source.
13. Click next and paste "git@github.com:darkmega12/summerProject.git" in URI and select ssh as connection protocol
14. Just traverse the NEXTs until you finish.


TO COMMIT AND PUSH:
1. Right-click the project
2. Go to Team - > commit...
3. Enter commit message and select all files to be pushed.
4. Select Commit and Push

TO PULL:
1. Right-click the project
2. Go to Team - > pull
