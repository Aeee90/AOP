package aocp.mix.util

object Util {

    fun error(text: String) = System.err.println(text)
    fun fetal(text: String): Nothing = throw Error(text)
}