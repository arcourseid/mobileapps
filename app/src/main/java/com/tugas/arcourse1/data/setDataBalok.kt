package com.tugas.arcourse1.data

object setDataBalok {
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData> {
        var que: ArrayList<QuestionData> = arrayListOf()

        var q1 = QuestionData(
            1,
            "Balok adalah bangun ruang yang sisinya paling banyak berbentuk ....  ",
            "A. Segi Empat",
            "B. Layang-layang",
            "C. Lingkaran",
            "D. Persegi Panjang",
            1
        )
        var q2 = QuestionData(
            2,
            "Balok mempunyai jumlah rusuk sebanyak ....  ",
            "A. 12 buah",
            "B. 15 buah",
            "C. 6 buah",
            "D. 8 buah",
            1
        )
        var q3 = QuestionData(
            3,
            "Rumus untuk mencari volume balok adalah ....",
            "A. V = P x l",
            "B. V = P x l x t",
            "C. V = P x a x t",
            "D. V = r x a x t",
            3
        )
        var q4 = QuestionData(
            4,
            "Gambar di atas merupakan jaring-jaring...",
            "A. Kubus",
            "B. Limas",
            "C. Balok",
            "D. Prisma Segi Enam",
            2
        )
        var q5 = QuestionData(
            5,
            "Rina mempunyai kotak pensil berbentuk balok dengan panjang 15 cm, lebar 8 cm dan tinggi 4 cm. Volume kotak pensil Rina adalah .... cm³ ",
            "A. 480",
            "B. 240",
            "C. 960",
            "D. 120",
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