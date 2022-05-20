package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class Quiz_question : AppCompatActivity(), View.OnClickListener {
    var mCurrentPosition = 1
    var mQuestionList:ArrayList<question>?=null
    var selectedOpstionPosition = 1
    var correctAnswer = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionList=constants.getQuestions()

        setQuestions()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionfour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestions() {
        val question: question? = mQuestionList!![mCurrentPosition - 1]

        defaultOptionsView()
        if (mCurrentPosition== mQuestionList!!.size){
            btn_submit.text= "Finish"
        }else{
            btn_submit.text="Submit"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_questions.text = question!!.qsn
        iv_image.setImageResource(question.image)
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionfour.text = question.optionFour
    }
    private fun defaultOptionsView(){
        val options= ArrayList<TextView>()
        options.add(0,optionOne)
        options.add(1,optionTwo)
        options.add(2,optionThree)
        options.add(3,optionfour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border
            )

        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNumber:Int){
        defaultOptionsView()
        selectedOpstionPosition=selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(this,R.drawable.selected_option_border)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {selectedOptionView(optionOne,1)}
            R.id.optionTwo -> {selectedOptionView(optionTwo,2)}
            R.id.optionThree -> {selectedOptionView(optionThree,3)}
            R.id.optionfour -> {selectedOptionView(optionfour,4)}
            R.id.btn_submit -> {
                if (selectedOpstionPosition==0){
                    mCurrentPosition++

                    when{
                       mCurrentPosition <= mQuestionList!!.size -> {setQuestions()}
                       else -> {
                           val intent = Intent(this, ResultActivity::class.java)
                           intent.putExtra("correct_answers", correctAnswer)
                           startActivity(intent)
                           finish()
                       }
                    }
                }
                    else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != selectedOpstionPosition ){
                        answerView(selectedOpstionPosition,R.drawable.wrong_answer_bg)
                    }else{
                        correctAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_bg)

                    if (mCurrentPosition== mQuestionList!!.size){
                          btn_submit.text= "Finish"
                    }else{
                         btn_submit.text="Go to next question"
                    }
                 selectedOpstionPosition=0
                }
            }

        }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1 -> {optionOne.background= ContextCompat.getDrawable(this,drawableView)}
            2 -> {optionTwo.background= ContextCompat.getDrawable(this,drawableView)}
            3 -> {optionThree.background= ContextCompat.getDrawable(this,drawableView)}
            4 -> {optionfour.background= ContextCompat.getDrawable(this,drawableView)}
        }
    }

}