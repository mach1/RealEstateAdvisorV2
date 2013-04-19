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

    $scope.getPercentageCompleted = function() {
      return ($scope.getQuestionId() / $scope.questions.length) * 100;
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
      $location.path('/result').search('');
    };

    $scope.currentQuestion = questionService.getQuestions()[$scope.getStepId()];
  }]);

  questionnaire.factory('questionService', ['$q', '$http', '$log', function($q, $http, $log) {
    var questions, realEstates, foo, answers;
    var fetchQuestions = function() {
      var deferred = $q.defer();
      if (questions) {
        deferred.resolve(questions);
      }
      $http.get('../rest/questions').then(function(response) {
        questions = response.data;
        deferred.resolve(response.data);
      }, function(reason) {
        $log.log("failed to get questions.");
      });
      return deferred.promise;
    };
    var fetchRealEstates = function(answers) {
      var deferred = $q.defer();
      $log.log(answers);
      $http.post('../rest/input', answers).then(function(response) {
        $log.log("result query success");
        $log.log("with answers:");
        $log.log(response.data);
        realEstates = response.data;
        deferred.resolve(realEstates);
      }, function(reason) {
        $log.log("failed to get results.");
        deferred.reject("Result query failed");
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