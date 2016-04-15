package br.com.managersystems.guardasaude.examoverview;


public class MainTabPresenter implements IMainTabPresenter,OnFinishListener {

    DummyDataInteractor dummyDataInteractor;
    IMainTab mainTab;

    public MainTabPresenter(NotificationFragment mainTabActivity) {
        dummyDataInteractor = new DummyDataInteractor();
        mainTab = mainTabActivity;
    }

    @Override
    public void attemptFetchDummyData() {
        dummyDataInteractor.getDummyData(this);
    }


    @Override
    public void onSucces(String[] dummyData) {
        mainTab.dummyDataSucces(dummyData);
    }
}
