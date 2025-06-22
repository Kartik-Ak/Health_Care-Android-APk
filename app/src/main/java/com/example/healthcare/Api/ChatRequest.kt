package com.example.healthcare.Api

data class Message(
    val role: String,
    val content: String
)

data class ChatRequest(
    val model: String = "deepseek/deepseek-chat",
    val messages: List<Message>
)
