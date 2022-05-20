package com.example.quizapp

data class question(
    val id:Int,
    val image:Int,
    val qsn:String,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer:Int
)