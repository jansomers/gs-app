package br.com.managersystems.guardasaude.examoverview;

import br.com.managersystems.guardasaude.DummyDatabase;

public class DummyDataInteractor {



    public void getDummyData(OnFinishListener onFinishListener) {
        onFinishListener.onSucces(DummyDatabase.dummyBrands());

    }
}
