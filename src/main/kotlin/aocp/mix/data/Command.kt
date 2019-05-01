package aocp.mix.data

import aocp.mix.util.Util

@ExperimentalUnsignedTypes
data class Command private constructor(val idx:String, val data: UByteArray) {

    fun getSign() = if(data[SIGN] == PLUS) PLUS else MINUS
    fun getC() = data[C].toInt()
    fun getADDRESS() = (data[ADDRESS1].toInt() shl 8) + data[ADDRESS2].toInt()
    fun getI() = data[I].toInt()
    fun getF() = data[F].toInt()

    override fun toString(): String = "${if(getSign() == PLUS) "+" else "-"} ${getADDRESS()}, ${getI()}(${getF()}) ${getC()}"

    companion object {
        val EMPTY_COMMAND = Command("EMPTY", UByteArray(6) {0.toUByte()})

        private const val SIGN = 0
        private const val ADDRESS1 = 1
        private const val ADDRESS2 = 2
        private const val I = 3
        private const val F = 4
        private const val C = 5

        private val PLUS = 1.toUByte()
        private val MINUS = 0.toUByte()

        const val EMPTY = "EMPTY"
        const val LDA = "LDA"
        const val LDX = "LDX"
        const val LD1 = "LD1"
        const val LD2 = "LD2"
        const val LD3 = "LD3"
        const val LD4 = "LD4"
        const val LD5 = "LD5"
        const val LD6 = "LD6"
        const val LDAN = "LDAN"
        const val LDXN = "LDXN"
        const val LD1N = "LD1N"
        const val LD2N = "LD2N"
        const val LD3N = "LD3N"
        const val LD4N = "LD4N"
        const val LD5N = "LD5N"
        const val LD6N = "LD6N"

        fun getCommand(op: String, S: Int, L: Int, R: Int, ADDRES: Int, I: UByte): Command {
            val s = if(S < 0) MINUS else PLUS
            val f = (8*L+R).toUByte()
            return when(op){
                LDA -> Command(LDA, ubyteArrayOf(s, (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, f, 8.toUByte()))
                LDX -> Command(LDX, ubyteArrayOf(s, (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, f, 15.toUByte()))
                LD1 -> Command(LD1, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 9.toUByte()))
                LD2 -> Command(LD2, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 10.toUByte()))
                LD3 -> Command(LD3, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 11.toUByte()))
                LD4 -> Command(LD4, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 12.toUByte()))
                LD5 -> Command(LD5, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 13.toUByte()))
                LD6 -> Command(LD6, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 14.toUByte()))
                LDAN -> Command(LDAN, ubyteArrayOf(s, (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, f, 16.toUByte()))
                LDXN -> Command(LDXN, ubyteArrayOf(s, (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, f, 23.toUByte()))
                LD1N -> Command(LD1N, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 17.toUByte()))
                LD2N -> Command(LD2N, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 18.toUByte()))
                LD3N -> Command(LD3N, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 19.toUByte()))
                LD4N -> Command(LD4N, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 20.toUByte()))
                LD5N -> Command(LD5N, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 21.toUByte()))
                LD6N -> Command(LD6N, ubyteArrayOf(s, (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, f, 22.toUByte()))
                else -> {
                    Util.error("$op is not Operation")
                    EMPTY_COMMAND
                }
            }
        }
    }
}