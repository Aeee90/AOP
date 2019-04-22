package aocp.mix.data

@ExperimentalUnsignedTypes
data class Command private constructor(val data: UByteArray) {

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

        fun LDA(F: UByte, ADDRES: Int, I: UByte): Command = Command(ubyteArrayOf(8.toUByte(), (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, F))
        fun LDX(F: UByte, ADDRES: Int, I: UByte): Command = Command(ubyteArrayOf(15.toUByte(), (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, F))
        fun LDi(i: Int, F: UByte, ADDRES: Int, I: UByte): Command {
            if(i <= 0 || 6 <= i) {
                error("Register I is between 1 to 6.")
            }
            return Command(ubyteArrayOf((8 + i).toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, F))
        }
        fun LDAN(F: UByte, ADDRES: Int, I: UByte): Command = Command(ubyteArrayOf(16.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, F))
        fun LDXN(F: UByte, ADDRES: Int, I: UByte): Command = Command(ubyteArrayOf(23.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, F))
        fun LDiN(i: Int, F: UByte, ADDRES: Int, I: UByte): Command {
            if(i <= 0 || 6 <= i) {
                error("Register I is between 1 to 6.")
            }
            return Command(ubyteArrayOf((16 + i).toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, F))
        }

    }
}