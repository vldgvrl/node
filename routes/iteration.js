var express = require('express');
var router = express.Router();
var taskFour = require('../tasks/fourthTask');

/* GET first task listing. */
router.get('/', function(req, res, next) {
  var result;  
  if(typeof req.query.push_value !== "undefined" && req.query.push_value !== "") {
    result = taskFour.callPush(req.query.push_value)
  }
  if(req.query.pop === 'true' ) {
    result = taskFour.callPop()
  }

  res.render('task', { 
    taskNum: '4',
    taskDescription: 'Iteraattori toteutus' ,
    response:taskFour.iterationResult(),
  })

});

module.exports = router;
