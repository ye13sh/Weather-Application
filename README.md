# Weather-Application
Java 8 Spring Boot and AngularJS 

# How to run
In your IntelliJ IDEA or VS code terminal give the following commands:-
1) mvn clean install
   This command gives you 'Build Success' (if you get 'Build Failed' in your IntelliJ then try it in VS code)
2) mvn spring-boot:run
   This command will run the project on localhost 8080

#Project running on 8080
Go to your browser then paste this link: http://localhost:8080/

Now frontend user-view will display and enter the city name to know the Temparature and Humidity

#Adding Parameters
To add more parameter you can add in WeatherMain class in Java and make required changes in WeatherDto class of custom method setMain
And in index.html add required feilds of the parameter in ng-show
