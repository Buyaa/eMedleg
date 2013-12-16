app.factory('topMenuResource', function($resource){
	return $resource('menuList.json');
});

app.factory('latestContent', function($resource){
	return $resource('lastContents.json');
});


app.factory('globalScope', function($resource){
	return {
		showLogin: "true"
	}
});

