package com.example.quizapp

object constants {
    fun getQuestions():ArrayList<question>{
        val questionList=ArrayList<question>()

        //1
        val que1= question(
            1,R.drawable.shivaji,"Who is this king?","Ashoka","Prithviraj",
            "Shivaji","Chandragrupta",3
        )
        questionList.add(que1)
        //2
        val que2= question(
            2,R.drawable.tipu_sultan,"What's the name of Tipu Sultan's kingdom??","Pataliputra","Mysore",
            "Saurastra","Delhi",2
        )
        questionList.add(que2)
        //3
        val que3= question(
            3,R.drawable.ashoka,"Ashoka,from which density??","Gupta","Maurya",
            "Mughal","Chahuan",2
        )
        questionList.add(que3)
        //4
        val que4= question(
            4,R.drawable.alauddin,"Who is this king?","Allauddin Khilji","Akbar",
            "jahangir","Sahajahan",1
        )
        questionList.add(que4)
        //5
        val que5= question(
            5,R.drawable.maharana_pratap,"Maharana Pratap is also known for? ","Rajsthani Jahan","Singh Sardar",
            "Samrat Saket","Mewari  Rana",4
        )
        questionList.add(que5)
        //6
        val que6= question(
            6,R.drawable.chandragupta,"Who is this king?","Ashoka","Prithviraj",
            "Shivaji","Chandragrupta",4
        )
        questionList.add(que6)
        //7
        val que7= question(
            1,R.drawable.babur,"Who is this king? He was known for founder of Mughal Density","Lucy","Jahangir",
            "Babur","Bahadur saha jaffar",3
        )
        questionList.add(que7)
        //8
        val que8= question(
            8,R.drawable.jahangir,"Where is the birth place of jahangir?","Fategarh Sikri","Lahore",
            "Hampi","Andijan",1
        )
        questionList.add(que8)
        //9
        val que9= question(
            19,R.drawable.akbar,"Birth year of Akbar??","1540","1542",
            "1547","2000",2
        )
        questionList.add(que9)




        return questionList
    }



}