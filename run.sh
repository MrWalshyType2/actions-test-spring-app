PID=sudo lsof -t -i:80

#sudo kill -9 $(sudo lsof -t -i:80)
sudo kill -9 $PID
wait

#echo "PORT 80: " + $(sudo lsof -t -i:80)
#if [ $PID ];
#then 
#  echo "KILLING PROCESS ID: " + $PID
#  sudo kill -9 $PID;
#fi;

cd actions-test-spring-app
mvn package

# no hangup (nohup) prevents app from stopping after logout, & puts in background;
# fix for race condition: https://stackoverflow.com/questions/29142/getting-ssh-to-execute-a-command-in-the-background-on-target-machine
sudo nohup java -jar ./target/spring_cucumber-0.0.1-SNAPSHOT.jar > foo.out 2> foo.err < /dev/null &
