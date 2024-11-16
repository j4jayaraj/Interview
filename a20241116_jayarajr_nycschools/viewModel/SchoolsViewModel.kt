package com.example.a20241116_jayarajr_nycschools.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20241116_jayarajr_nycschools.SchoolsRepository
import com.example.a20241116_jayarajr_nycschools.model.SchoolListResponseItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SchoolsViewModel() : ViewModel() {
    private var job: Job? = null
    val schoolsRepository = SchoolsRepository()
    var schoolsMutableState =mutableStateListOf<SchoolListResponseItem>()
    init {
        getSchoolDetails()
    }

    fun getSchoolDetails() {
        job = viewModelScope.launch {
            schoolsRepository.getSchoolDetails().collectLatest {
                schoolsMutableState=it.toMutableStateList()
                print(it)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        if (job?.isActive == true) {
            job?.cancel()
        }
    }
}