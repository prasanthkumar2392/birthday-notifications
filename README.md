
# Birthday remainder using spring boot and postgres. 

 Users can add their list of the birthdays for which they need a remainder through whatsapp or sms.
 
 After adding the events, users will be given a Hateoas URL to view the list of the events in the database.
 
 A scheduler will run on a fixed interval daily to check the updates and send the messages to user on preferred timings.
 
#TODO
 
 User should able to sigup for the first time and creates login credentials.
 Currently there is a limit in number of messages with the Twilio.
 Sending Reminder in Whats app
 

## Bring up postgres using docker-compose
Start postgres
```
docker-compose up -d
```
Initialize the below command to use the postgres interface in container 
```
docker exec -it container-id bin/bash/ 
```

## DB UI through adminer image

URL : http://localhost:8081/adminer
login username: postgres
password: example


### Libraries Used
Java 11
Postgres
Twilio
Spring web
Hateoas
