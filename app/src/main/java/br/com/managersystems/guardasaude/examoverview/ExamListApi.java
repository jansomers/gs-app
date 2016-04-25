package br.com.managersystems.guardasaude.examoverview;


import br.com.managersystems.guardasaude.examoverview.domain.ExamList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ExamListApi {

    @GET("mobile/listExams")
    Call<ExamList> getExamList(
            @Query("user") String username,
            @Query("token") String token,
            @Query("orderBy") String orderBy,
            @Query("sortBy") String sortBy,
            @Query("maxValue") String maxValue,
            @Query("offsetValue")String offsetValue,
            @Query("filterBy")String filterBy,
            @Query("accessRole") String accessRole);
}
