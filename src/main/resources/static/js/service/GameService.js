(function(){
  angular.module("fizzBuzzApp").service("gameService", [ '$http', function($http) {

    this.getMaxNumber = function(){
      return $http({
          method : 'GET',
          url : '/maxNum'
      });
    }

    this.startGame = function(numRandom){
      return $http({
          method : 'POST',
          url : '/start',
          data : numRandom
      });
    }

  }]); //ends service code
})(); //ends angular code here
