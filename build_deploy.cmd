@echo off

:deploy
git pull
cmd /c mvnw clean
cmd /c mvnw install
cd .\kits && cmd /c mvnw tomcat7:redeploy
cd ..\

pause

goto deploy