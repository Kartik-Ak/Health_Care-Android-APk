package com.example.healthcare.Api

data class ChatResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
)
