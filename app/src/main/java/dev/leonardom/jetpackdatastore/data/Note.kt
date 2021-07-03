package dev.leonardom.jetpackdatastore.data

data class Note(
    val id: Int,
    val title: String,
    val priority: NotePriority,
    val completed: Boolean
)

enum class NotePriority {
    LOW, MEDIUM, HIGH
}
