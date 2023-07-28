package com.example.hellokotlin

class Cat constructor(){
    // init 블럭은 primary 생성자의 일부
    init{
        println("고양이가 생겼어요!")
    }
    //뒤늦은 초기화가 가능한 필드  lateinit 예약어 붙여서 선언하기
    lateinit var name:String
    // 코틀린의 이 코드는 자바에서 super() 와 비슷하다.
    constructor(name:String):this() { // this() primary 생성자를 호출하는 표현식이다.
        println("고양이의 이름은:${name}")
        this.name=name
    }
}

class Dog constructor(){
    init{
        println("강아지가 생겼어요!")
    }
    //필드
    // null 값을 허용하고 싶으면  type 뒤에 ? 를 붙인다
    var name:String? = null
    constructor(name:String):this(){
        // null 이 가능한 type 공간에  null 이 불가능한 type 공간에 담긴 값을 대입하는것은 가능
        this.name=name
    }
}

fun main() {
    val c1 = Cat("호두")
    val c2 = Cat()
    println(c1.name)
    //lateinit 필드에 값을 넣어주고
    c2.name = "키티"
    //필드를 참조해야 한다.
    println(c2.name)

    // null 값이 가능한 data type 은  type 뒤에 ? 를 붙여 주어야한다.
    // String type 과  String? type 은  다른 type 으로 간주된다.
    var myName: String? = null
    myName = "김구라"
    myName = null
    // Int(숫자) type 도 null 을 넣어 놓고 값을 나중에 대입할수 있다.
    var myNum: Int? = null
    myNum = 999
    myNum = null

    var d1 = Dog("멍멍이")
    var d2 = Dog()
    println(d1.name)
    println(d2.name)
}
