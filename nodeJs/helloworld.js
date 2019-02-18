/*
* author zhaoheng
* date 20190214
* propose nodejs demo
*/

"use strict"

class Person{
    constructor(name,age,sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
        console.log(this);
    }

    set name(name){
        console.log("set name");
        this._name=name;
    }
    get name(){
        console.log("get name");
        return this._name;
    }
    set age(age){
        console.log("set age");
        this._age=age;
    }
    get age(){
        console.log("get age");
        return this._age;
    }
    set sex(sex){
        console.log("set sex");
        this._sex=sex;
    }
    get sex(){
        console.log("get sex");
        return this._sex;
    }
    toString(){
        return "name: "+this.name+",age: "+this.age+",sex:"+this.sex;
    }
}

class AsiaPerson extends Person{
    constructor(name,age,sex,language){
        super(name,age,sex);
        console.log(this);
        this.language=language;    
    }
    toString(){
        return "I'am asia person ,my name: "+this.name+",age: "+this.age+",sex:"+this.sex;
    }
}


function FuncPerson(name,age,sex){
    this.name=name;
    this.age=age;
    this.sex=sex;
}

FuncPerson.prototype.toString=function(){
    return "I'am asia person ,my name: "+this.name+",age: "+this.age+",sex:"+this.sex;
}

function AsiaFuncPerson(name,age,sex,language){
    FuncPerson.apply(this,[name,age,sex]);
    this.language=language;
}

AsiaFuncPerson.prototype=new FuncPerson();



// var person=new AsiaFuncPerson("zhaoheng",24,"男");
// console.log(person.toString());


// 复习一下闭包知识
function closure(name,age,sex){
    this.name=name;
    this.age=age;
    this.sex=sex;
    return function (){
        console.log(name);
    }
}

try {
    const num=10;
    num=11;
} catch (error) {
    //console.log(error);
}

(function(){
   function hi(){
       console.log(this);
   }
   hi();
   console.log(arguments);
})(global)