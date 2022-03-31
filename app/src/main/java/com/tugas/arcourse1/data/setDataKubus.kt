package com.tugas.arcourse1.data

object setDataKubus {
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData> {
        var que: ArrayList<QuestionData> = arrayListOf()

        var q1 = QuestionData(
            1,
            "1.\tJumlah rusuk kubus sebanyak ....",
            "A. 15",
            "B. 12",
            "C. 6",
            "D. 8",
            1
        )
        var q2 = QuestionData(
            2,
            "Sebuah limas segi empat memiliki alas berbentuk persegi dengan panjang sisi 50 cm. Jika tinggi sisi tegak 75 cm, maka luas permukaannya ....  cm²",
            "A. 10.000",
            "B. 10.250",
            "C. 10.500",
            "D. 11.000",
            1
        )
        var q3 = QuestionData(
            3,
            "Bangun kubus adalah bangun yang sisi-sisinya berbentuk ....  ",
            "A. Segitiga",
            "B. Persegi",
            "C. Persegi Panjang",
            "D. Trapesium",
            3
        )
        var q4 = QuestionData(
            4,
            "Rumus untuk mencari volume kubus adalah ....",
            "A. V = s x s",
            "B. V = r x r x r",
            "C. V = p x l x t",
            "D. V = s x s x s",
            2
        )
        var q5 = QuestionData(
            5,
            "Rino mempunyai kotak pensil berbentuk kubus dengan panjang sisinya 20 cm. Lalu Doni juga punyak kotak pensil berbentuk kubus dengan panjang sisi 15 cm. Selisih volume kotak pensil mereka berdua adalah .... cm³",
            "A. 4.600",
            "B. 8.000",
            "C. 3.375",
            "D. 4.625",
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