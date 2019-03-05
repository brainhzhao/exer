
window.onload=function(){
    var check=document.getElementById("alertItemChecked");

    check.addEventListener("click",function(e){
        var items=document.getElementsByName("item");
        console.log(items.entries())
        
    }) 
}
