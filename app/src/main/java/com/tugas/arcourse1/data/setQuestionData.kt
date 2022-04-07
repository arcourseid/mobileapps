package com.tugas.arcourse1.data

object setQuestionData {
    const val score:String="score"

    fun getQuestionBalok():ArrayList<QuestionData> {
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

    fun getQuestionKubus():ArrayList<QuestionData> {
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

    fun getQuestionLimas(): ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()

        var q1= QuestionData(
            1,
            "Sebuah limas segitiga sama sisi mempunyai sisi ganjal 12 cm dan tinggi ganjal 8 cm. Jika tinggi sisi tegak segitiga selimut ialah 20 cm, maka luas permukaan limas tersebut ....  cm²",
            "A. 408",
            "B. 410",
            "C. 416",
            "D. 418",
            1
        )
        var q2= QuestionData(
            2,
            "Sebuah limas segi empat memiliki alas berbentuk persegi dengan panjang sisi 50 cm. Jika tinggi sisi tegak 75 cm, maka luas permukaannya ....  cm²",
            "A. 10.000",
            "B. 10.250",
            "C. 10.500",
            "D. 11.000",
            1
        )
        var q3= QuestionData(
            3,
            "Alas sebuah limas berbentuk persegi. Tinggi limas 36 cm. Jika volume limas 1.452 cm³, maka panjang rusuk alas limas .... cm",
            "A. 8",
            "B. 9",
            "C. 11",
            "D. 13",
            3
        )
        var q4= QuestionData(
            4,
            "Sebuah bangun berbentuk limas, alasnya berbentuk persegi dengan sisi 18 cm. Jika tinggi limas tersebut 20 cm, maka volumenya .... cm³",
            "A. 2.150",
            "B. 2.160",
            "C. 2.164",
            "D. 2.170",
            2
        )
        var q5= QuestionData(
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

    fun getQuestionLingkaran(): ArrayList<QuestionData>{
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