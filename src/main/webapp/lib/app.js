var app = angular.module('myApp',  ['ngResource', 'ngRoute', 'ui.bootstrap'] );


app.controller('topMenuCtrl', function($scope, topMenuResource, $modal, $http, userAuth){
    $scope.login = {};
    $scope.login.btnTxt = "Нэвтрэх/Login in";
    console.log($scope.login);
    console.log($scope.login.btnTxt);

	topMenuResource.query(function(menuData){
		$scope.topMenuData = menuData;
		console.log($scope.topMenuData);
	});


    console.log(userAuth.isLoggedIn);

    if(userAuth.isLoggedIn == false){
        $scope.login.btnTxt = "Нэвтрэх/Login in";
        console.log($scope.login.btnTxt);
    } else {
        $scope.login.btnTxt = "Гарах/Logout";
        console.log($scope.login.btnTxt);
    };


    $scope.login = function(){
        var modelInstance = $modal.open({
            templateUrl: './lib/partials/loginPar.html',
            controller: ModalInstanceCtrl
        });
    };
    //console.log($scope.user.ner);
    var ModalInstanceCtrl = function ($scope, $modalInstance, $log) {


        $scope.user = {};
        $scope.user.name = "";
        $scope.user.pass = "";

        $scope.userLogin = function(){
            $http({method: 'POST', url:'/userAuthenticate', data: $scope.user})
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

});

app.controller('latestNewsCtrl', function($scope, latestContent){
	latestContent.query(function(newsData){
		$scope.latestNewsData = newsData;
		console.log($scope.latestNewsData);
	});
});

