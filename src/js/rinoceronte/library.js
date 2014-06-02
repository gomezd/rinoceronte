
var global = this,
    lib = Java.type('rinoceronte.Library');

global.sayMyName = lib.sayMyName;

global.threeTimes = function (name) {
    for (var i = 1; i <= 3; i++) {
        sayMyName(i + ': ' +name);
    }
};