/**
 * Created by oshko on 12/30/13.
 */

app.controller('topMenuCtrl', function($scope, $cookieStore, $http, topMenuResource, $modal, userLoginSer, userAuthSer){
    topMenuResource.query(function(menuData){
        $scope.topMenuData = menuData;
    });
    
    $scope.user={};
    
    $scope.login = function(){
        var modelInstance = $modal.open({
            templateUrl: './lib/partials/loginPar.html',
            controller: ModalInstanceCtrl
        });
        modelInstance.result.then(function(){
          	$scope.user.btnTxt="Гарах";
          	$scope.user.link = $scope.logout;
        	$scope.user.fullName = userAuthSer.getUser().fullName;
        });
   };
	$scope.logout = function() {
		userAuthSer.setUser(null);
		$cookieStore.remove('loggedUser');
		delete $http.defaults.headers.common['X-Auth-Token'];		
		$scope.user.btnTxt = "Нэвтрэх";
    	$scope.user.link = $scope.login;
    	$scope.user.fullName="";
	};
   
    
    console.log(typeof(userAuthSer.getUser()));
    if(userAuthSer.getUser()===null){
    	$scope.user.btnTxt = "Нэвтрэх";
    	$scope.user.link = $scope.login;
    	$scope.user.fullName="";
    } else {
    	$scope.user.btnTxt = "Гарах";
    	$scope.user.link = $scope.logout;
    	$scope.user.fullName = userAuthSer.getUser().fullName;
    }
    
    

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
});



app.controller('latestNewsCtrl', function($scope, latestContent){
    latestContent.query(function(newsData){     // latestContent service
        $scope.latestNewsData = newsData;
    });
});

