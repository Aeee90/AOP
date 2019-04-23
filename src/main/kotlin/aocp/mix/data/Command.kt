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

        fun getCommnad(op: String, L: Int, R: Int, ADDRES: Int, I: UByte): Command = when(op){
            "LDA" -> Command(ubyteArrayOf(8.toUByte(), (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LDX" -> Command(ubyteArrayOf(15.toUByte(), (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD1" -> Command(ubyteArrayOf(9.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD2" -> Command(ubyteArrayOf(10.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD3" -> Command(ubyteArrayOf(11.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD4" -> Command(ubyteArrayOf(12.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD5" -> Command(ubyteArrayOf(13.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD6" -> Command(ubyteArrayOf(14.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LDAN" -> Command(ubyteArrayOf(16.toUByte(), (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LDXN" -> Command(ubyteArrayOf(23.toUByte(), (ADDRES shr 8).toUByte().toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD1N" -> Command(ubyteArrayOf(17.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD2N" -> Command(ubyteArrayOf(18.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD3N" -> Command(ubyteArrayOf(19.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD4N" -> Command(ubyteArrayOf(20.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD5N" -> Command(ubyteArrayOf(21.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            "LD6N" -> Command(ubyteArrayOf(22.toUByte(), (ADDRES shr 8).toUByte(), ADDRES.toUByte(), I, (8*L+R).toUByte()))
            else -> {
                error("$op is not Operation")
            }
        }
    }
}