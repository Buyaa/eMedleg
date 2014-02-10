app.factory('topMenuResource', function($resource){
	return $resource('menuList');  
});

app.factory('latestContent', function($resource){
	return $resource('lastContents');
});


app.factory('userLoginSer', function($http, $log, $cookieStore, userAuthSer){
    return {
        userCheck: function(user, modalInstance){
        $http({method: 'POST', url:'./userAuthenticate', data: { email: user.email, password: user.password} })
            .success(function(data, status, headers, config){
            	userAuthSer.setUser(data);
            	$http.defaults.headers.common['X-Auth-Token'] = data.token;
            	$cookieStore.put('loggedUser', data);
                modalInstance.close();
            })
            .error(function(data, status, headers, config){
                if(status !=200){
                    user.alert = "Таны нэвтэрч орох НЭР болон НУУЦ ҮГ таарахгүй байна! Нягтлаад дахиад оруулаарай.";
                    user.email = "";
                    user.password = "";
                }
            });
    }};
});

app.factory('userAuthSer', function(){
	var userInfo=null;
    return {
        setUser: function(user){
        	userInfo=user;
        },
        getUser: function(){
        	return userInfo;
        }
    };
});
