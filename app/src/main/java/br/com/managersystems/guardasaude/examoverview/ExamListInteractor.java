package br.com.managersystems.guardasaude.examoverview;


import android.util.Log;
import android.os.Handler;

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
        examListApi = initiateRetrofit();
    }

    @Override
    public ExamListApi initiateRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ExamListApi.class);
    }



    @Override
    public void getExamList(final OnCallExamListFinishedListener listener, final String userName, final String token, final String orderBy, final String sortBy, final String maxValue, final String offsetValue, final String filterBy, final String accesRole) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (examListApi == null) {
                    examListApi = initiateRetrofit();
                }
                Call<ExamList> call = examListApi.getExamList(userName,token,orderBy,sortBy,maxValue,offsetValue,filterBy,accesRole);
                call.enqueue(new Callback<ExamList>() {
                    @Override
                    public void onResponse(Call<ExamList> call, Response<ExamList> response) {
                        listener.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<ExamList> call, Throwable t) {
                        listener.onFailure();
                    }
                });


            }
        }, 2000);
        /*if(examListApi==null){
            examListApi = initiateRetrofit();
        }else{
            System.out.println("Examlistapi" + examListApi.getClass());
            Call<ExamList> call = examListApi.getExamList(userName,token,orderBy,sortBy,maxValue,offsetValue,filterBy,accesRole);
            call.enqueue(new Callback<ExamList>() {
                @Override
                public void onResponse(Call<ExamList> call, Response<ExamList> response) {
                    Log.d(this.getClass().getSimpleName(), "Call happened");
                }

                @Override
                public void onFailure(Call<ExamList> call, Throwable t) {
                    Log.d(this.getClass().getSimpleName(), "Call failed");
                }
            });*/

    }


}
