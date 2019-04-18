package aocp.mix

internal class Register(dataSize: Int){

    val valuse: Array<Byte>
    var sign: Int = Sign.POSITIVE.value

    init {
        valuse = Array(dataSize) { 0.toByte() }
    }

    operator fun set(from: Int, to:Int){

    }

    operator fun get(from: Int, to:Int): Int{
        return 0
    }

    enum class Sign private constructor(val value: Int){
        POSITIVE(1),
        NEGATIVE(-1)
    }
}