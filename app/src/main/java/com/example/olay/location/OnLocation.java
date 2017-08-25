package com.example.olay.location;


/**
 * Created by OlAy on 2017/8/23.
 */

public interface OnLocation {
    //定位开始
    void OnStart();

    //定位结束
    void OnFinish();

    //卫星暂停
    void OnPause();

    //定位成功
    void OnSuccess(LocationData locationData);

    //定位失败
    void OnFailed(int error);

}
