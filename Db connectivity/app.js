// An HTTP Server to receive values & modify db accordingly.

var express = require('express')
var bodyParser = require('body-parser')
var mysql = require('mysql');

var app = express()

// Establish connection with Database
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : '',
  database : 'test'
});


app.use(bodyParser.json())

app.get('/', function (req, res) {
  res.send('Hello from Team 3!')
})

app.post('/', function (req, res) {
  	res.send('Got a POST request')

  	console.log(req.body)

    var option = req.body.option;

    switch(option){

      // User registers to receive status update using Missed call service.
      case 'registration':
      console.log('Register a user!');
      addNewEntry(req.body)
      break;


      default:
      console.log('Hi from UI!')
      break;
    }
 
  	
})

app.listen(8080, function () {
  console.log('Server app listening on port 8080!')
})


function addNewEntry(body) {

  var query = "INSERT INTO users VALUES('" + body.fname + "', '" + body.lname + "', '" + body.email 
              + "')"

  connection.query(query, function (error, results, fields) {

      if (error) console.log(error);
      else
      console.log("User inserted successfully");
  });
}


  
