package com.tugas.arcourse1.data

object setDataLingkaran {
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData> {
        var que: ArrayList<QuestionData> = arrayListOf()

        var q1 = QuestionData(
            1,
            "1.Garis BC pada lingkaran di bawah ini disebut ….",
            "A. Busur",
            "B. Tali Busur",
            "C. Diameter",
            "D. Tembereng",
            4
        )
        var q2 = QuestionData(
            2,
            "Jari-jari lingkaran adalah...",
            "A. Tali busur lingkaran yang melalui titik pusat",
            "B. Jarak antara pusat ke garis lengkung lingkaran",
            "C. Garis tegak lurus antara titik pusat dan tali busur",
            "D. Garis lengkung dari satu titik ke titik lain pada garis lengkung lingkaran.",
            2
        )
        var q3 = QuestionData(
            3,
            "Rumus keliling lingkaran adalah ....",
            "A. 2πd ",
            "B. πd",
            "C. 2πr",
            "D. πr",
            3
        )
        var q4 = QuestionData(
            4,
            "Diameter lingkaran yang mempunyai keliling 22 cm adalah .... (π = )",
            "A. 7 cm",
            "B. 14 cm",
            "C. 21 cm",
            "D. 30 cm",
            2
        )
        var q5 = QuestionData(
            5,
            "Luas lingkaran yang berdiameter 20 cm adalah …. (π = 3,14)",
            "A. 154 cm2",
            "B. 314 cm2",
            "C. 616 cm2",
            "D. 1256 cm2",
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