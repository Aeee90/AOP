package aocp.mix.data

@ExperimentalUnsignedTypes
data class Command private constructor(val idx:String, val data: UByteArray) {



    fun getC() = data[OP].toInt()
    fun getADDRESS() = (data[ADDRESS1].toInt() shl 8) + data[ADDRESS2].toInt()
    fun getI() = data[I].toInt()
    fun getF() = data[F].toInt()

    override fun toString(): String = "${this.getC()} ${getADDRESS()}, ${getI()}(${getF()})"

    companion object {
        private const val OP = 0
        private const val ADDRESS1 = 1
        private const val ADDRESS2 = 2
        private const val I = 3
        private const val F = 4

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

        fun getCommand(op: String, L: Int, R: Int, ADDRES: Int, I: UByte): Command = when(op){
            LDA -> Command(LDA, ubyteArrayOf(8.toUByte(), (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LDX -> Command(LDX, ubyteArrayOf(15.toUByte(), (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD1 -> Command(LD1, ubyteArrayOf(9.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD2 -> Command(LD2, ubyteArrayOf(10.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD3 -> Command(LD3, ubyteArrayOf(11.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD4 -> Command(LD4, ubyteArrayOf(12.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD5 -> Command(LD5, ubyteArrayOf(13.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD6 -> Command(LD6, ubyteArrayOf(14.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LDAN -> Command(LDAN, ubyteArrayOf(16.toUByte(), (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LDXN -> Command(LDXN, ubyteArrayOf(23.toUByte(), (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD1N -> Command(LD1N, ubyteArrayOf(17.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD2N -> Command(LD2N, ubyteArrayOf(18.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD3N -> Command(LD3N, ubyteArrayOf(19.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD4N -> Command(LD4N, ubyteArrayOf(20.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD5N -> Command(LD5N, ubyteArrayOf(21.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            LD6N -> Command(LD6N, ubyteArrayOf(22.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            else -> {
                error("$op is not Operation")
            }
        }
    }
}