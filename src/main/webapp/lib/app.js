var app = angular.module('myApp',  ['ngResource', 'ngRoute', 'ui.bootstrap'] );


app.controller('topMenuCtrl', function($scope, topMenuResource, $modal, userService){
	topMenuResource.query(function(menuData){
		$scope.topMenuData = menuData;
		console.log($scope.topMenuData);
	});

    $scope.open = function(){
        var modelInstance = $modal.open({
            templateUrl: './lib/partials/loginPar.html',
            controller: ModalInstanceCtrl
        });
    };
    //console.log($scope.user.ner);
    var ModalInstanceCtrl = function ($scope, $modalInstance) {


        $scope.user = {};
        $scope.user.name = "";
        $scope.user.pass = "";


        $scope.userLogin = function () {
            $modalInstance.close();

            console.log($scope.user.name);
            console.log($scope.user.pass);

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

