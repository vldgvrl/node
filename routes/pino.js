var express = require('express');
var router = express.Router();
var taskOne = require('../tasks/firstTask');

/* GET first task listing. */
router.get('/', function(req, res, next) {
  var result;  
  if(typeof req.query.push_value !== "undefined" && req.query.push_value !== "") {
    result = taskOne.callPush(req.query.push_value)
  }
  if(req.query.pop === 'true' ) {
    result = taskOne.callPop()
  }

  res.render('task', { 
    taskNum: '1',
    taskDescription: 'Pino toteutus' ,
    response: taskOne.lifoImplementation(),
  })

});

module.exports = router;
