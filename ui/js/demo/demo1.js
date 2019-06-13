var optionValue='';

window.onload=function(){
    var check=document.getElementById("select");
    var childs=check.childNodes;
    
    check.addEventListener("change",function(e){
        var optionElement=document.getElementById("value"+this.value);
        optionElement.style.backgroundColor=optionElement.style.backgroundColor=="red"?"":"red";
        console.log(this.value);    
    })
    //check.addEventListener("select")
   /*  console.log(childs.forEach(function(currentNode,key,parent){
        if(currentNode.nodeType==1){
            console.log(key);
            currentNode.addEventListener("select",function(e){
                var optionElement=document.getElementById("value"+this.value);
                optionElement.style.backgroundColor=optionElement.style.backgroundColor=="red"?"":"red";
                console.log(this.value);    
            })
        }
    })); */

    
}
