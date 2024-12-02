package ink.ryanbr

object AdventUtils {

  fun readFile(path: String) = this::class.java.classLoader
      ?.getResource(path)
      ?.readText()
      ?: error("Unable to locate spec 👀")

}
