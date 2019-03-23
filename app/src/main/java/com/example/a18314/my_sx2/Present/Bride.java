package com.example.a18314.my_sx2.Present;

import com.example.a18314.my_sx2.Bean.Food;
import com.example.a18314.my_sx2.Model.InterFaceModel;
import com.example.a18314.my_sx2.Model.RequestModel;
import com.example.a18314.my_sx2.View.UpdateData;

public class Bride implements RequestModel.SuccessModel,SendData{

    private UpdateData activity;
    private InterFaceModel requestmodel;
    public Bride(UpdateData activity){
        this.activity=activity;
        requestmodel=new RequestModel(this);
    }

    @Override
    public void senddata(String Url) {
        requestmodel.getResult(Url);
    }

    @Override
    public void success(Food.data[] data) {
        activity.RefreshData(data);
    }
}
