package pablo.example.com.fortnitetracker.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import pablo.example.com.fortnitetracker.DTOs.Player;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;


public interface ForniteTrackerApiService {

    @Headers("TRN-Api-Key:bab40abf-6620-4688-8871-6ab76d73f7c9")
    @GET("v1/profile/{platform}/{epicName}")
    Observable<Player> getInfoFornite(@Path("platform") String platform , @Path("epicName") String epic_nickname);

    static ForniteTrackerApiService Factory(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.fortnitetracker.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ForniteTrackerApiService.class);
    }


}
