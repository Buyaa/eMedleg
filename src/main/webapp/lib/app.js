var app = angular.module('myApp',  ['ngResource', 'ngRoute','ngCookies', 'ui.bootstrap'] );



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

app.run(function($rootScope, $http, $location, $cookieStore, userAuthSer) {
	
	/* Reset error when a new view is loaded */
//	$rootScope.$on('$viewContentLoaded', function() {
//		delete $rootScope.error;
//	});
	
	$rootScope.hasRole = function(role) {
		var user=userAuthSer.getUser();
		if ( user===null) {
			return false;
		}
		
		if (user.roles === undefined) {
			return false;
		}
		
		if (user.roles[role] === undefined) {
			return false;
		}
		
		return user.roles[role];
	};
	
	
	 /* Try getting valid user from cookie or go to login page */
//	var originalPath = $location.path();
//	$location.path("/");
	var loggedUser = $cookieStore.get('loggedUser');
	if (loggedUser !== undefined) {
		userAuthSer.setUser(loggedUser); 
		$http.defaults.headers.common['X-Auth-Token'] = loggedUser.token;
//		$location.path(originalPath);
	}else{
		delete $http.defaults.headers.common['X-Auth-Token'];
	}
	
});