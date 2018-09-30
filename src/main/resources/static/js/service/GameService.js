/**
* @name=App.js
* @author= Aleix Riba
* @version = 1.0
* @description = services file that communicates with the backend part
* @date= 2018-09-30
*/

(function(){
  angular.module("fizzBuzzApp").service("gameService", [ '$http', function($http) {

    /**
    * @name= getMaxNumber()
    * @author= Aleix Riba
    * @version = 1.0
    * @description = function that communicates with backend in the entry point to know the maximum number
    * @date= 2018-09-30
    * @params= none
    * @return = backend response
    */
    this.getMaxNumber = function(){
      return $http({
          method : 'GET',
          url : '/maxNum'
      });
    }

    /**
    * @name= startGame(numRandom)
    * @author= Aleix Riba
    * @version = 1.0
    * @description = function that communicates with backend in the entry point to start the game
    * @date= 2018-09-30
    * @params= numRandom: random number that is by the number that the game starts
    * @return = backend response
    */
    this.startGame = function(numRandom){
      return $http({
          method : 'POST',
          url : '/start',
          data : numRandom
      });
    }

  }]); //ends service code
})(); //ends angular code here
