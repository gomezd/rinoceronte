
var lib = Java.type('rinoceronte.Library'),
	
	sayMyName = lib.sayMyName,

	threeTimes = function (name) {
		for (var i = 1; i <= 3; i++) {
			sayMyName(i + ': ' +name);
		}
	};