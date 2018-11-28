package pablo.example.com.fortnitetracker.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pablo.example.com.fortnitetracker.DTOs.FinalStats;
import pablo.example.com.fortnitetracker.DTOs.Player;
import pablo.example.com.fortnitetracker.DTOs.PlayerStatsDetail;
import pablo.example.com.fortnitetracker.Repository.ForniteTrackerRP;

import java.util.ArrayList;
import java.util.List;

public class ForniteViewModel extends ViewModel {

    private ForniteTrackerRP ftRepository = ForniteTrackerRP.getInstance();
    public List<FinalStats> finalStatsList = new ArrayList<>();
    public MutableLiveData<List<FinalStats>> playerDetailsMutableLiveData = new MutableLiveData<>();
    PlayerStatsDetail playerStatsDetail;

    public void getData(String platform, String epicName) {

        ftRepository.getAllInfo(platform, epicName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Player>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Player player) {
                        if (player != null) {
                            finalStatsList.clear();

                            playerStatsDetail = player.getPlayerStats().getPlayerStatsDetail();
                            finalStatsList.add(playerStatsDetail.getScore());
                            finalStatsList.add(playerStatsDetail.getTrnRating());
                            finalStatsList.add(playerStatsDetail.getMatches());
                            finalStatsList.add(playerStatsDetail.getKd());
                            playerDetailsMutableLiveData.postValue(finalStatsList);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        System.out.println("------>>Error!!");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
