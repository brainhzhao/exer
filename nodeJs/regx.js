/*
*  @auathor zhaoheng
* propose regular expression demo
*/


reg=/^([0-9]){3}([a-z]){1}$/g

console.log(reg.match("012a").$1);

