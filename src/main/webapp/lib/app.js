var app = angular.module('myApp',  ['ngResource', 'ngRoute', 'ui.bootstrap'] );



app.config(function($routeProvider){
    $routeProvider.when('/',
        {
            templateUrl: './lib/partials/newsPar.html',
            controller: 'latestNewsCtrl'
        });
    $routeProvider.when('/addnews',
        {
            templateUrl: './lib/partials/addNewsPar.html'
        });

});