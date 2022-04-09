var express = require('express');
var router = express.Router();
var taskThree = require('../tasks/thirdTask');

/* GET first task listing. */
router.get('/', function(req, res, next) {
  var result;  
  if(typeof req.query.push_value !== "undefined" && req.query.push_value !== "") {
    result = taskThree.callPush(req.query.push_value)
  }
  if(req.query.pop === 'true' ) {
    result = taskThree.callPop()
  }

  res.render('task', { 
    taskNum: '3',
    taskDescription: 'Iteraattori toteutus' ,
    response:taskThree.iterationResult(),
  })

});

module.exports = router;
