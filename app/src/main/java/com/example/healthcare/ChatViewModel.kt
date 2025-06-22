package com.example.healthcare

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcare.Api.ChatRequest
import com.example.healthcare.Api.ChatResponse
import com.example.healthcare.Api.Message
import com.example.healthcare.Api.RetrofitcCient

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatViewModel : ViewModel() {

    private val _messages = MutableStateFlow<List<Pair<String, Boolean>>>(
        listOf("Hello! How can I help you?" to false)
    )
    val messages: StateFlow<List<Pair<String, Boolean>>> = _messages

    private val _isLoading = MutableStateFlow(false) // NEW
    val isLoading: StateFlow<Boolean> = _isLoading   // NEW

    fun sendMessage(userMessage: String) {
        val updatedList = _messages.value.toMutableList()
        updatedList.add(userMessage to true)
        _messages.value = updatedList

        _isLoading.value = true  // show loading animation

        val request = ChatRequest(
            messages = listOf(
                Message(role = "user", content = userMessage)
            )
        )

        RetrofitcCient.apiService.getChatResponse(request).enqueue(object : Callback<ChatResponse> {
            override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                _isLoading.value = false // hide loading

                if (response.isSuccessful) {
                    val reply = response.body()?.choices?.get(0)?.message?.content
                        ?: "Sorry, I didn’t understand that."
                    _messages.value = _messages.value + (reply to false)
                } else {
                    _messages.value = _messages.value + ("Error: ${response.code()}" to false)
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                _isLoading.value = false // hide loading
                _messages.value = _messages.value + ("Failure: ${t.message}" to false)
            }
        })
    }
}
