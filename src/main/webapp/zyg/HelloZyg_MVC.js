var myModule = angular.module("HelloZyg",[]);

myModule.controller("helloZyg" , ['$scope' ,
		function HelloZyg($scope){
			$scope.greeting = {
				text: 'Hello1'
			}
		}
	]);