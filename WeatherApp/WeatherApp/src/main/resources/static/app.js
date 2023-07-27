angular.module('WeatherApp', [])
    .controller('WeatherController', function ($scope, $http) {
        $scope.city = '';
        $scope.weatherData = null;

        $scope.getWeather = function () {
            $http.get('https://weather-application-7ce0.up.railway.app/weather/' + $scope.city) //'http://localhost:8080/weather/
                .then(function (response) {
                    $scope.weatherData = response.data;
                })
                .catch(function (error) {
                    console.error('Error fetching weather data: ', error);
                });
        };
    });
