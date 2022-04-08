var express = require('express');
var secondTask = require('../tasks/secondTask');
var router = express.Router();

/* GET second task listing. */
router.get('/', function(req, res, next) {
  var result;  
  if(typeof req.query.push_value !== "undefined" && req.query.push_value !== "") {
    console.log("push query defined");
    result = secondTask.callEnqueue(req.query.push_value)
  }
  if(req.query.dequeue === 'true' ) {
    console.log("query defined correctly")
    result = secondTask.callDequeue()
  }

  res.render('task', { 
    taskNum: '2',
    taskDescription: 'Jono-toteutus' ,
    response: secondTask.fifoImplementation(),
  })

});

module.exports = router;
