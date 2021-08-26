#PID=sudo lsof -t -i:80
#echo $PID

#sudo kill $PID
#wait

sudo kill -9 $(sudo lsof -t -i:80)
wait

echo "PORT 80: " + $(sudo lsof -t -i:80)
#if [ $PID ];
#then 
#  echo "KILLING PROCESS ID: " + $PID
#  sudo kill -9 $PID;
#fi;

cd actions-test-spring-app;
mvn package;

# no hangup (nohup) prevents app from stopping after logout, & puts in background;
sudo nohup java -jar ./target/spring_cucumber-0.0.1-SNAPSHOT.jar &
