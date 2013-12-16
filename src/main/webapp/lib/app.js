var app = angular.module('myApp', ['ngResource']);

app.controller('parentCtrl', function($scope){
	$scope.login = {
			show: "false" 
	};
	console.log($scope.login.show);
});

app.controller('topMenuCtrl', function($scope, topMenuResource, globalScope){
	topMenuResource.query(function(menuData){
		$scope.topMenuData = menuData;
		console.log($scope.topMenuData);
	});
	
	$scope.navBtnClick = function(){
		show = globalScope.showLogin;
		console.log(showLogin);
	}
});

app.controller('latestNewsCtrl', function($scope, latestContent){
	latestContent.query(function(newsData){
		$scope.latestNewsData = newsData;
		console.log($scope.latestNewsData);
	});
});

