 async bla() {
  var myHttpRequest = new Promise();

  myHttpRequest.then(function (value) {
    console.log("received Result")
  });

  var concat = [].concat([1,2,4]);

  console.log("bla")
}