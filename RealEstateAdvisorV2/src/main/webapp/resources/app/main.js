require.config({
  baseUrl : 'app/',
  paths : {
    'angular'     : 'vendor/angular/angular-1.0.6.min',
    'ui.bootstrap'  : 'vendor/angular/ui-bootstrap-tpls-0.2.0.min',
    'jquery'      : 'vendor/jquery/jquery-1.9.1'
  },
  shim : {
    'angular': {
      deps : [ 'jquery' ],
      exports: 'angular'
    },
    'ui.bootstrap': {
      deps : [ 'angular' ],
      exports : 'angular'
    }
  }
});

require([
  'angular',
  'views',
  'app'
], function(angular) {
  'use strict';

  var names   = [],
      modules = [],
      i, mod;

  // Flatten the modules array
  modules = modules.concat.apply(modules, [].slice.call(arguments, 1));

  // Extract module names
  for (i = 0; i < modules.length; i += 1) {
    mod = modules[i];
    // Validate that the module exists and it really has a name
    if (typeof mod !== "undefined" && mod.name) {
      names.push(mod.name);
    } else {
      console.error('Seems that either a loaded view or component has no name or is broken. Please fix this problem.');
    }
  }

  console.log("Bootstrapping application with modules:", names);
  // Start the main angular application
  angular.bootstrap(document, names);
});
