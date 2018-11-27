package pablo.example.com.fortnitetracker.Repository;

import io.reactivex.Observable;
import pablo.example.com.fortnitetracker.DTOs.Player;
import pablo.example.com.fortnitetracker.Services.ForniteTrackerApiService;;

public class ForniteTrackerRP   {
    private static volatile ForniteTrackerRP ourInstance = new ForniteTrackerRP();

   public static ForniteTrackerRP getInstance() {
        if (ourInstance == null){
            synchronized (ForniteTrackerRP.class){
                if (ourInstance == null) {
                    ourInstance = new ForniteTrackerRP();
                }
            }
        }
        return ourInstance;
    }

    private ForniteTrackerRP() {
    }


    private ForniteTrackerApiService apiService = ForniteTrackerApiService.Factory();


    public Observable<Player> getPlayer(String platform, String epicName){

        return apiService.getInfoFornite(platform, epicName);
    }

}
