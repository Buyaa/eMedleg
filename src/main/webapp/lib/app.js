var app = angular.module('myApp',  ['ngResource', 'ngRoute', 'ui.bootstrap'] );


app.controller('topMenuCtrl', function($scope, topMenuResource, $modal, $http, userAuthSer, userLoginSer){
	topMenuResource.query(function(menuData){
		$scope.topMenuData = menuData;
		console.log($scope.topMenuData);
	});

    $scope.user = {};
    $scope.user.auth = userAuthSer.isLoggedIn;



    if(userAuthSer.isLoggedIn == false){
        $scope.user.btnTxt = "Нэвтрэх";
        console.log($scope.user.btnTxt);

        $scope.login = function(){
            var modelInstance = $modal.open({
                templateUrl: './lib/partials/loginPar.html',
                controller: ModalInstanceCtrl
            });
        };

        var ModalInstanceCtrl = function ($scope, $modalInstance) {


            $scope.user = {};
            $scope.user.email = "";
            $scope.user.password = "";
            $scope.user.alert = "";
            var modalInstance = $modalInstance;

            $scope.userLogin = function(){
                userLoginSer.userCheck($scope.user, modalInstance);
            };

            $scope.cancel = function () {
                modalInstance.dismiss('cancel');
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

