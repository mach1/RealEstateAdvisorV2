define([
  'angular',
  'ui.bootstrap'
], function(angular) {
  'use strict';

  // Define a module
  var questionnaire = angular.module('questionnaire', ['ui.bootstrap']);

  // Add a controller to questionnaire module
  questionnaire.controller('questionnaireController', ['$scope', '$location', '$http', 'questionService', '$routeParams', function($scope, $location, $http, questionService, $routeParams) {
    $scope.questions = [];

    questionService.getQuestions().then(function(questions) {
      for (var i = 0; i < questions.length; i++) {
        questions[i].selected = "0";
      }
      $scope.questions = questions;
      $scope.currentQuestion = questions[$scope.getStepId()];
    });

    console.log($location.search());
    if (typeof $location.search().id === 'undefined') {
      $location.search({id: 0});
    }
    $scope.$watch(function() {
      return $location.search();
    }, function() {
      $scope.currentQuestion = $scope.questions[$scope.getStepId()];
    });

    $scope.getStepId = function() {
      return parseInt($location.search().id || 0);
    };

    $scope.getQuestionId = function() {
      return $scope.getStepId() + 1;
    };

    $scope.getNextStepId = function() {
      return $scope.getStepId() + 1;
    };

    $scope.getPreviousStepId = function() {
      return $scope.getStepId() - 1;
    };

    $scope.isFirstQuestion = function() {
      return $scope.getStepId() === 0;
    };

    $scope.isLastQuestion = function() {
      return ($scope.getStepId() + 1) === $scope.questions.length;
    };
    $scope.submit = function() {
      var getAnswers = function() {
        var answerKeyList = [], answerId, question, answer;
        for (var i = 0; i < $scope.questions.length; i++) {
          question = $scope.questions[i];
          answerId = parseInt(question.selected);
          answer = question.answerList[answerId].answerEnumString;
          answerKeyList.push(answer);
        }
        return answerKeyList;
      }, answers;
      questionService.setAnswers(getAnswers());
      $location.path('/result');
    };

    $scope.currentQuestion = questionService.getQuestions()[$scope.getStepId()];
  }]);

  questionnaire.directive('questionnaire', function() {
    return {
        replace: true,
        restrict: 'E',
        controller: 'questionnaireController',
        templateUrl: 'app/views/questionnaire/questionnaire-partial.html'
    };
  });

  questionnaire.factory('questionService', ['$q', '$http', function($q, $http) {
    var questions, realEstates, foo, answers;
    var fetchQuestions = function() {
      var deferred = $q.defer();
      if (questions) {
        deferred.resolve(questions);
      }
      $http.get('../rest/questions').then(function(response) {
        questions = response.data;
        deferred.resolve(response.data);
      });
      return deferred.promise;
    };
    var fetchRealEstates = function(answers) {
      var deferred = $q.defer();
      if (realEstates) {
        deferred.resolve(realEstates.data);
      }
      $http.post('../rest/input', answers).then(function(response) {
        realEstates = response.data;
        deferred.resolve(realEstates);
      });
      return deferred.promise;
    };
    return {
      getQuestions: function() {
        return fetchQuestions();
      },
      setAnswers: function(userAnswers) {
        answers = userAnswers;
      },
      getRealEstates: function() {
        return fetchRealEstates(answers);
      },
      setFoo: function(data) {
        foo = data;
      },
      getFoo: function() {
        return foo;
      }
    };
  }]);

  return questionnaire;
});