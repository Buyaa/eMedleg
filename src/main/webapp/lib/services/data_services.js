app.factory('topMenuResource', function($resource){
	return $resource('menuList.json');
});

app.factory('latestContent', function($resource){
	return $resource('lastContents.json');
});



app.factory('userAuthSer', function(){
    return {
        userSet: function(user){

        },
        isLoggedIn: false,
        username: null
    };
});

app.factory('userInfoSer', function(){
    return {
        userInfoObj:{}
    };
});

app.factory('userLoginSer', function($http, $log, userAuthSer, userInfoSer){
    return {
        userCheck: function(user, modalInstance){
        $http({method: 'POST', url:'./userAuthenticate', data: { email: user.email, password: user.password} })
            .success(function(data, status, headers, config){
                userInfoSer = data;
                $log.info(data, status, headers, config);
                userAuthSer.isLoggedIn = true;
                console.log(userAuthSer.isLoggedIn);
                console.log(userInfoSer);
                modalInstance.close();
                return user;
            })
            .error(function(data, status, headers, config){
                if(status !=200){
                    user.alert = "Таны нэвтэрч орох НЭР болон НУУЦ ҮГ таарахгүй байна! Нягтлаад дахиад оруулаарай."
                    user.email = "";
                    user.password = "";
                }
                $log.warn(status);
                return user;
            });
    }};
});



/*

app.factory('md5Generator'), function(md5){
    return {
        generateMd5 : function(obj){
            md5.createHash(obj);
            return obj;
        }
    };
};*/
