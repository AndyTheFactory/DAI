// Test interactively by cutting and pasting into the Firebug console.

function square(x) { return(x * x); }

function triple(x) { return(x * 3); }

function doOperation(f, x) { return(f(x)); }

doOperation(square, 5);

doOperation(triple, 10);

var functions = [square, triple];

functions[0](10);

functions[1](20);