angular.module('WeatherApp', [])
    .controller('WeatherController', function ($scope, $http) {
        $scope.city = '';
        $scope.weatherData = null;

        $scope.getWeather = function () {
            $http.get('http://localhost:8080/weather/' + $scope.city)
                .then(function (response) {
                    $scope.weatherData = response.data;
                })
                .catch(function (error) {
                    console.error('Error fetching weather data: ', error);
                });
        };
    });
