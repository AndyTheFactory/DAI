// This function is specific to specific IDs,
// but the rest of the functions are generic and reusable.
// Experienced JavaScript programmers could just
// make an anonymous function (closure) on the main page that
// captures the id and calls showIndicatorRegion.

function showWorkingIndicator(data) {
  showIndicatorRegion(data, "workingIndicator", "ajaxBank:ajaxMessage2");
}

// Show an HTML element, fire off the Ajax request,
// then hide the element once the response comes back.
// In real life I would probably use jQuery and
// $("#workingIndicator").hide() and ...show()
// But I wanted to keep this as simple as possible
// for folks that don't know jQuery.
// Similarly, experienced JavaScript programmers would use
// namespaces, not functions at the top level. 
// For example:
//   var coreservlets = {};
//   var coreservlets.showWorkingIndicator = function(data) { ... }
// This approach is omitted
// here to keep things simpler for JavaScript newbies.

function showIndicatorRegion(data, spinnerRegionId, messageRegionId) {
  if (data.status == "begin") {
	clearExistingText(messageRegionId);
    showElement(spinnerRegionId);
  } else if (data.status == "complete") {
    hideElement(spinnerRegionId);
  } 
}

// If you resubmit a form that already has a previous answer, you do not
// want the previous results shown below the "Loading data from server..."
// message. This clears it. Note that the raw HTML ID is the if of the JSF
// form, then a colon, then the id of the JSF input element.

function clearExistingText(id) {
	document.getElementById(id).innerHTML = "";
}

function showElement(id) {
  document.getElementById(id).style.display 
    = "block";
}

function hideElement(id) {
  document.getElementById(id).style.display 
    = "none";
}

