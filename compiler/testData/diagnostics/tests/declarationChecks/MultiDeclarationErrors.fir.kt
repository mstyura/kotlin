// !WITH_NEW_INFERENCE
package a

class MyClass {
    fun component1(i: Int) {}
}

class MyClass2 {}

fun MyClass2.component1() = 1.2
fun MyClass2.component1() = 1.3

fun test(mc1: MyClass, mc2: MyClass2) {
    val (<!INAPPLICABLE_CANDIDATE!>a<!>, <!UNRESOLVED_REFERENCE!>b<!>) = mc1
    val (<!INAPPLICABLE_CANDIDATE!>c<!>) = mc2

    //a,b,c are error types
    use(a, b, c)
}

fun use(vararg a: Any?) = a