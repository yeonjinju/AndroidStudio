package com.example.hellokotlin

/*
    kotlin 기본 data type

    Byte, Short, Int, Long
    Float, Double
    Boolean, Char
    String

    var 또는 val 로 시작을 해서 identifiet(변수명):type=value; 합니다요
    타입 생략 가능한 경우가 있음
 */

fun main() {
    // 정수를 담을 수 있는 num 이라는 이름의 변수를 만들어서 10을 대입하기
    var num:Int = 10
    // 실수를 담을 수 있는 num2라는 이름의 변수를 만들어서 10.1 대입하기
    var num2:Double=10.1
    // myName 이라는 변수에 문자열 "김구라" 대입하기
    var myName:String="김구라"
    // yourName 이라는 상수의 문자열 "해골" 대입하기
    val yourName:String="해골"
    // 변수는 값 변경이 가능하다.
    myName="누구징";
    // 상수는 값이 한번 결정되면 값 변경 불가
    // yourName="원숭이"

    // type 추론이 가능한 경우 type 생략 가능
    var num3=30
    var ourName="에이콘"
    var num4=10.1

    // 변수를 미리 선언하고
    var num5:Int
    // 값을 나중에 넣을 수 있다.
    num5=50

    // 변수나 상수를 미리 만들고 값을 나중에 넣고 싶으면 반드시 type을 명시 해야한다.
    var num6:Int
    num6=60

    // 상수도 미리 만들어놓고
    val PI:Float
    // 값을 나중에 대입할 수 있다.
    PI=3.14159f
    // 상수는 값이 한번 결정이 되면 값 변경 불가
    // PI=3.14f

    println("main() 함수가 종료 됩니다!")
}