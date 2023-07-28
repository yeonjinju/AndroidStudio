package com.example.hellokotlin

/*
    kotlin 에서의 배열과 반복문
 */

fun main() {
    // 수정 불가능한 목록(List)
    val names:List<String> = listOf<String>("kim", "lee", "park")
    val animals= listOf<String>("dog", "cat", "elephant")
    val nums= listOf(10, 20, 30)

    // 배열의 참조
    println(names[0])
    println(names[1])
    println(names[2])

    // 수정불가
    // names[0]="김구라"

    // indices 는 index 의 복수형 (names 배열의 index 로 이루어진 배열)
    val result=names.indices

    for (i in names.indices){
        println(i)
    }
    println("-------------------")
    for (i in names.indices){
        println(names[i])
    }
    println("-------------------")
    for (i in names.indices){
        println("$i:${names[i]}")
    }
    println("--------------------")
    for (item in names){
        println(item)
    }
    println("--------------------")
    names.forEach{
        println(it)
    }
}