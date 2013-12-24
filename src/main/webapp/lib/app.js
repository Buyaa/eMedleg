var app = angular.module('myApp',  ['ngResource', 'ngRoute', 'ui.bootstrap'] );


app.controller('topMenuCtrl', function($scope, topMenuResource, $modal, $http, userAuthSer){
	topMenuResource.query(function(menuData){
		$scope.topMenuData = menuData;
		console.log($scope.topMenuData);
	});

    $scope.user = {};

    if(userAuthSer.isLoggedIn == false){
        $scope.user.btnTxt = "Нэвтрэх";
        console.log($scope.user.btnTxt);

        $scope.login = function(){
            var modelInstance = $modal.open({
                templateUrl: './lib/partials/loginPar.html',
                controller: ModalInstanceCtrl
            });
        };

        var ModalInstanceCtrl = function ($scope, $modalInstance, $log) {


            $scope.user = {};
            $scope.user.email = "";
            $scope.user.password = "";

            $scope.userLogin = function(){
                $http({method: 'POST', url:'./userAuthenticate', data: { email: $scope.user.email, password: $scope.user.password} })
                    .success(function(data, status, headers, config){
                        $log.info(data, status, headers, config);
                    })
                    .error(function(data, status, headers, config){
                        $log.warn(data, status, headers, config)
                    });
                $modalInstance.close();
            };



            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
        };
    } else {
        $scope.user.btnTxt = "Гарах";
        console.log($scope.user.btnTxt);
    };



});



app.controller('latestNewsCtrl', function($scope, latestContent){
	latestContent.query(function(newsData){
		$scope.latestNewsData = newsData;
		console.log($scope.latestNewsData);
	});
});

