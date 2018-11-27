package pablo.example.com.fortnitetracker.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
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
    public MutableLiveData<List<FinalStats>> playerDetailsMutableLiveData = new MutableLiveData<>();
    public List<FinalStats> dataList = new ArrayList<>();
    PlayerStatsDetail data;

    public void getData(String platform, String epic_name) {

        ftRepository.getPlayer(platform, epic_name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Player>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Player player) {
                        if(player!=null) {
                            dataList.clear();

                            data = player.getPlayerStats().getPlayerStatsDetail();
                            System.out.println("------------------->" + data.toString());
                            dataList.add(data.getScore());
                            dataList.add(data.getTrnRating());
                            dataList.add(data.getMatches());
                            dataList.add(data.getKd());
                            playerDetailsMutableLiveData.postValue(dataList);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.d("Failed ",e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
