function  swapNames(data){
	var  ndata  = new  Object();
	ndata.fname  =  data.sname;
	ndata.sname  = data.fname;
	return  ndata;
}

var http  = require('http');

http.createServer(function  (req,  res)  {
	req.setEncoding("utf8");
	var result  = '';
	req.on('data',  function  (chunk)  {
		result  += chunk;
	});
	req.on('end',  function  () {
		var data  = swapNames(JSON.parse(result));
		res.writeHead(200,  {'Content-Type':  'application/json'});
		res.end(JSON.stringify(data)  + '\n');
	});
}).listen(8881,  "127.0.0.1");

console.log('Server  running  at http://127.0.0.1:8881/');