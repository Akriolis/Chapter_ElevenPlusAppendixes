import java.time.Period

/**
 * DSL construction
 * domain-specific languages
 *
 * SQL is DSL
 *
 */

/**
 * Lambdas with receivers (again)
 */

fun buildString(
    builderAction: (StringBuilder) -> Unit
): String{
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

fun buildString2(
    builderAction: StringBuilder.() -> Unit
): String{
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

/**
 * Extension function type
 *
 * StringBuilder.() -> Unit called receiver type and the value of that type
 * passed to the lambda becomes the receiver object
 *
 * the receiver (sb) becomes an implicit receiver (this) when la,bda body is invoked
 */

fun buildString3(builderAction: StringBuilder.() -> Unit): String =
    StringBuilder().apply(builderAction).toString()

/**
 * The "invoke" convention: objects callable as functions
 *
 * conventions are specially named functions that are called not through
 * the regular method-call syntax, but using concise notations
 */

/**
 * Building Kotlin projects
 */

/**
 * Documenting Kotlin code
 *
 * Kdoc
 * @return
 * @param
 */

/**
 * The Kotlin ecosystem
 */

fun main(){
    val s = buildString {
        it.append("Hello, ")
        it.append("World!")
    }
    println(s)

    val s2 = buildString2 {
        this.append("Hello, ")
        append("World!")
    }
    println(s2)

    val appendExcl: StringBuilder.() -> Unit =
        { this. append("!")}

    val appendExcl2: StringBuilder.() -> Unit =
        { this. append("Hello, World!")}

    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExcl()
    println(stringBuilder)

    println(buildString2(appendExcl))

    val s3 = buildString3(appendExcl2)
    println(s3)

    val map = mutableMapOf(1 to "one")
    map.apply {this [2] = "two"}
    with (map) {this [3] = "three"}
    println(map)

    val bavarianGreeter = Greeter("Salut")
    bavarianGreeter("Victor")
    // under the hood it is bavarianGreeter.invoke("Victor")

    val i1 = Issue("IDEA-154446", "IDEA", "Bug", "Major",
    "Save settings failed")

    val i2 = Issue("KT-12183", "Kotlin", "Feature", "Normal", "Intention: convert several calls on the same receiver to with/apply")

    val predicate = ImportantIssuesPredicate("IDEA")

    for (issue in listOf(i1,i2).filter(predicate)){
        println(issue.id)
    }




}