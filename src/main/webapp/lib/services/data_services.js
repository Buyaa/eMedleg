app.factory('topMenuResource', function($resource){
	return $resource('menuList.json');
});

app.factory('latestContent', function($resource){
	return $resource('lastContents.json');
});



/*
app.factory('userService', function($http, $log){
    return {

        addUser: function(successcb){
            $http({method: 'GET', url: 'lastContents.json'})
            .success(function(data, status, headers, config){
                $log.info(data, status, headers, config);
            })
            .error(function(data, status, headers, config){
                $log.warn(data, status, headers, config);
            });
        }
    };


});*/
