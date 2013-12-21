app.factory('topMenuResource', function($resource){
	return $resource('menuList.json');
});

app.factory('latestContent', function($resource){
	return $resource('lastContents.json');
});



app.factory('userService', function(){

    var checkUser = function(user){
        user = user.name + " Orson";

    };

    return checkUser;

});