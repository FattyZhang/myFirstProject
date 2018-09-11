var myModule = angular.module("myZyg",[]);
myModule.directive("zyg" ,function(){
	return {
		restrict: 'E',
	    template: '<div>Hi ZYG!</div>',
	    replace: true
	}
});
