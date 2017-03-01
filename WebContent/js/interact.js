/**
 * 
 */
loadManga();
function loadManga(){
	new Ajax.Request(context + "/MangalistController", {
		method: "post",
		onSuccess : function(response){
			$('mainDiv').update(response.responseText);
		},
		onFailure: function(response){
			alert("There is something wrong. Check your internet connection.");
		}
	});
}

function selectTitle(){
	alert($F('titles'));
}

function selectChapter(){
	alert($F('chapters'));
}

function selectPage(){}
function selectNext(){}
function selectPrevious(){}