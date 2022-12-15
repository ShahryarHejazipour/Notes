package com.tispunshahryar960103.notes.utils

data class DataOrException<T,Boolean,exception:Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: exception? = null,
)