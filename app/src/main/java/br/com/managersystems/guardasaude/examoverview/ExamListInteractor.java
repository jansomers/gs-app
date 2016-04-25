package br.com.managersystems.guardasaude.examoverview;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import br.com.managersystems.guardasaude.examoverview.domain.ExamList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExamListInteractor implements IExamListInteractor{

    private final String BASE_URL= "https://www.guardasaude.com.br/";
    private ExamListApi examListApi;


    public ExamListInteractor() {
        initiateRetrofit();
    }

    @Override
    public void initiateRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        examListApi= retrofit.create(ExamListApi.class);
    }

    @Override
    public void getExamList(final OnCallExamListFinishedListener listener, String userName, String token, String orderBy, String sortBy, String maxValue, String offsetValue, String filterBy, String accesRole) {

        if(examListApi==null){
            initiateRetrofit();
        }else{
            Call<ExamList> call = examListApi.getExamList(userName,token,orderBy,sortBy,maxValue,offsetValue,filterBy,accesRole);
            call.enqueue(new Callback<ExamList>() {
                @Override
                public void onResponse(Call<ExamList> call, Response<ExamList> response) {
                    Log.d(this.getClass().getSimpleName(), "IN ONRESPONSE CALL");
                    listener.onSuccess(response.body());
                }

                @Override
                public void onFailure(Call<ExamList> call, Throwable t) {
                    Log.d(this.getClass().getSimpleName(),"IN ONFAILURE CALL", t.getCause());
                    listener.onFailure();
                }
            });
        }
    }


}
