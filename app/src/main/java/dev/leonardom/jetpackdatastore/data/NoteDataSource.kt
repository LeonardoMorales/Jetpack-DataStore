package dev.leonardom.jetpackdatastore.data

fun getNoteList() = listOf(
    Note(
        id = 1,
        title = "Sacar el perro a pasear",
        priority = NotePriority.MEDIUM,
        completed = false
    ),
    Note(
        id = 2,
        title = "Hacer deberes de la casa",
        priority = NotePriority.HIGH,
        completed = true
    ),
    Note(
        id = 3,
        title = "Suscribire al canal de Leo",
        priority = NotePriority.HIGH,
        completed = false
    ),
    Note(
        id = 4,
        title = "Aprender Jetpack DataStore",
        priority = NotePriority.LOW,
        completed = true
    ),
    Note(
        id = 5,
        title = "Tomar curso de Android",
        priority = NotePriority.MEDIUM,
        completed = false
    ),
    Note(
        id = 6,
        title = "Finalizar curso iOS",
        priority = NotePriority.HIGH,
        completed = false
    ),
    Note(
        id = 7,
        title = "Mandar paquete a amigo",
        priority = NotePriority.LOW,
        completed = true
    ),
    Note(
        id = 8,
        title = "Tomar agua",
        priority = NotePriority.HIGH,
        completed = true
    ),
    Note(
        id = 9,
        title = "Hacer ejercicio",
        priority = NotePriority.MEDIUM,
        completed = false
    )
)