package br.com.managersystems.guardasaude.examoverview;


public interface IExamListInteractor {
    void initiateRetrofit();
    void getExamList(final OnCallExamListFinishedListener listener, final String userName, final String token,final String orderBy,final String sortBy, final String maxValue, final String offsetValue, final String filterBy, final String accesRole);
}
