package com.example.simselection.sorting

data class Sort_DataModel(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val amount :Int,
    val date : String
)



//: Comparator<Sort_DataModel>, Comparable<Any> {
//    override fun compare(o1: Sort_DataModel?, o2: Sort_DataModel?): Int {
//        return o1?.firstName!!.compareTo(o2!!.firstName)
//
//    }
//}
