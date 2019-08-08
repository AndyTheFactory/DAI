// Test interactively by cutting and pasting into the Firebug console.

function square(x) { return(x * x); }

square(10);
(function(x) { return(x * x); })(10);

function makeMultiplier(n) {
  return(function(x) { return(x * n); });
}

var factor = 5;
var f = makeMultiplier(factor);

f(3);
factor = 500;
f(3);