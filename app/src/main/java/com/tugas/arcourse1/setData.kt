package com.tugas.arcourse1

object setData {

    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()

        var q1=QuestionData(
            1,
            "Sebuah limas segitiga sama sisi mempunyai sisi ganjal 12 cm dan tinggi ganjal 8 cm. Jika tinggi sisi tegak segitiga selimut ialah 20 cm, maka luas permukaan limas tersebut ....  cm²",
            "A. 408",
            "B. 410",
            "C. 416",
            "D. 418",
            1
        )
        var q2=QuestionData(
            2,
            "Sebuah limas segi empat memiliki alas berbentuk persegi dengan panjang sisi 50 cm. Jika tinggi sisi tegak 75 cm, maka luas permukaannya ....  cm²",
            "A. 10.000",
            "B. 10.250",
            "C. 10.500",
            "D. 11.000",
            1
        )
        var q3=QuestionData(
            3,
            "Alas sebuah limas berbentuk persegi. Tinggi limas 36 cm. Jika volume limas 1.452 cm³, maka panjang rusuk alas limas .... cm",
            "A. 8",
            "B. 9",
            "C. 11",
            "D. 13",
            3
        )
        var q4=QuestionData(
            4,
            "Sebuah bangun berbentuk limas, alasnya berbentuk persegi dengan sisi 18 cm. Jika tinggi limas tersebut 20 cm, maka volumenya .... cm³",
            "A. 2.150",
            "B. 2.160",
            "C. 2.164",
            "D. 2.170",
            2
        )
        var q5=QuestionData(
            5,
            "Diketahui limas segiempat beraturan T.ABCDT.ABCD dengan AB=BC=5√2 cmAB=BC=52 cm dan TA=13 cmTA=13 cm. Jarak titik AA ke garis TCTC adalah...",
            "A. 60/13 cm",
            "B. 64/13 cm",
            "C. 120/13 cm",
            "D. 10 cm",
            3
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que
    }
}