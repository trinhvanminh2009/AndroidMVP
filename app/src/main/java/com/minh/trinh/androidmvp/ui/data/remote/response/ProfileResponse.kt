package com.minh.trinh.androidmvp.ui.data.remote.response

import com.minh.trinh.androidmvp.ui.base.model.BaseDataResponse
import com.minh.trinh.androidmvp.ui.base.model.BaseItemResponse
import com.minh.trinh.androidmvp.ui.data.model.Profile

class ProfileResponse : BaseDataResponse<ProfileResponse.Data>() {
    class Data : BaseItemResponse<Profile>()
}