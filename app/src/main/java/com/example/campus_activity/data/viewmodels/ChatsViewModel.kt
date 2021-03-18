package com.example.campus_activity.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.campus_activity.data.model.ChatModel
import com.example.campus_activity.data.model.Result
import com.example.campus_activity.data.repository.ChatsRepository
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
class ChatsViewModel
constructor(
    roomId: String
) : ViewModel() {

    private val repository = ChatsRepository(roomId)

    val allChats: LiveData<Result<List<ChatModel>>> = repository.allChats.asLiveData()

    fun insertChatOnClick(message:String){
        repository.insertChatToDB(message)
    }

    fun deleteChat(chatModel: ChatModel){
        repository.deleteChat(chatModel)
    }
}