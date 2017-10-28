package kr.hs.buil.neighborhoodweather;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.health.PackageHealthStats;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import kr.hs.buil.neighborhoodweather.model.forecast.Forecast3day;
import kr.hs.buil.neighborhoodweather.model.forecast.ForecastInfo;
import kr.hs.buil.neighborhoodweather.model.weather.Hourly;
import kr.hs.buil.neighborhoodweather.model.weather.Weather;
import kr.hs.buil.neighborhoodweather.model.weather.WeatherInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {
    WeatherService APIService;
    LocationManager locationManager = null;
    LocationListener locationListener = null;

    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;

    double latitude = 0.0;
    double longitude = 0.0;

    ArrayList<String> cities = new ArrayList<>();
    String currentCity = "";

    @BindView(R.id.tvLocation)
    TextView tvLocation;
    @BindView(R.id.tvSky)
    TextView tvSky;
    @BindView(R.id.tvTemperMax)
    TextView tvTemperMax;
    @BindView(R.id.tvTemperMin)
    TextView tvTemperMin;
    @BindView(R.id.tvTemperNow)
    TextView tvTemperNow;
    @BindView(R.id.layoutTemperature)
    LinearLayout layoutTemperature;
    @BindView(R.id.layoutBackground)
    LinearLayout layoutBackground;
    @BindView(R.id.rvForecast)
    RecyclerView rvForecast;
    @BindView(R.id.lvCity)
    ListView lvCity;

    private ForecastAdapter mForecastAdapter;

    boolean isExiting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        APIService = WeatherService.retrofit.create(WeatherService.class);

        boolean isGranted = checkLocationPermission();

        if (isGranted) {
            initLocationManger();
            getLocationInfo();
        }
    }

    @Override
    public void onBackPressed() {
        if(isExiting == false){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isExiting = false;
                }
            }, 2000);
            Toast.makeText(this,"앱을 종료하려면 '뒤로' 버튼을 한 번 더 누르세요.",
                     Toast.LENGTH_SHORT).show();

            isExiting = true;
        }else{
            finish();
        }
    }

    final int REQUEST_PERMISSION = 1000;

    boolean checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSION);
            return false;
        }

        return true;
    }

    void initLocationManger() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

    }

    void getLocationInfo() {
        if (isGPSEnabled || isNetworkEnabled) {
            final List<String> mListProviders = locationManager.getProviders(false);
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    longitude = location.getLongitude();
                    latitude = location.getLatitude();

                    Address address = getAddressFromLocation(latitude, longitude);

                    if(address == null)
                        return;
                    String city;
                    String[] temp = address.getAddressLine(0).split(" ");
                    if(temp.length >=3) {
                        if(temp[0].equals("대한민국"))
                            city = temp[1] + " "+temp [2] + " " + temp [3];
                        else
                            city = temp[0] + " "+temp[1] + " "+ temp[2];
                    }else{
                        city = address.getAddressLine(0);
                    }
                    currentCity = city;


                    locationManager.removeUpdates(locationListener);

                    currentCity = city;
                    tvLocation.setText(currentCity);

                    if(cities.contains(currentCity) == false)
                        cities.add(currentCity);
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                            android.R.layout.simple_list_item_1, cities);
                    lvCity.setAdapter(adapter);

                    getCurrentWeather(latitude, longitude);
                    getForecast3Days(latitude, longitude);
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                    Toast.makeText(MainActivity.this,
                            "onStatusChanged",
                            Toast.LENGTH_LONG)
                            .show();
                }


                @Override
                public void onProviderEnabled(String provider) {

                    Toast.makeText(MainActivity.this,
                            "onProviderEnabled",
                            Toast.LENGTH_LONG)
                            .show();
                }

                @Override
                public void onProviderDisabled(String provider) {

                    Toast.makeText(MainActivity.this,
                            "onProviderDisabled",
                            Toast.LENGTH_LONG)
                            .show();
                }
            };
            for (String name : mListProviders) {
                if (checkLocationPermission())
                    locationManager.requestLocationUpdates(name, 1000, 5, locationListener);
                
            }
        } else {
            Toast.makeText(this,
                    "GPS, Network 설정이 꺼져있습니다. 설정화면으로 넘어갑니다.",
                    Toast.LENGTH_LONG)
                    .show();
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }

    }

    Address getAddressFromLocation(double latitude, double longitude) {


        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.KOREA);
        List<Address> addresses;

        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);

            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                return address;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    Address getLocationFromAddress(String addressString) {
        Geocoder geocoder = new Geocoder(MainActivity.this);
        Address address = null;

        try {
            List<Address> addresses
                    = geocoder.getFromLocationName(addressString, 5);

            if (addresses.isEmpty() == false)
                address = addresses.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return address;
    }

    void getCurrentWeather(double latitude, double longitude) {
        APIService.getCurrentWeather(1, String.valueOf(latitude), String.valueOf(longitude)).enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                if (response.body() != null) {
                    WeatherInfo info = response.body();

                    if (info.weather.hourly.isEmpty() == false) {
                        Hourly hourly = info.weather.hourly.get(0);


                        tvSky.setText(hourly.sky.name);
                        String temp = ((int)Double.parseDouble(hourly.temperature.tc)) +"℃";
                        String tempMin = ((int)Double.parseDouble(hourly.temperature.tmin)) +"℃";
                        String tempMax = ((int)Double.parseDouble(hourly.temperature.tmax)) +"℃";
                        tvTemperMax.setText(tempMax);
                        tvTemperMin.setText(tempMin);
                        tvTemperNow.setText(temp);
                        layoutTemperature.setVisibility(View.VISIBLE);

                        View rootView = getWindow().getDecorView().getRootView();
                        if(hourly.sky.code.equals("SKY_O01")){
                            rootView.setBackgroundResource(R.mipmap.bg_sunny);
                        }else if(hourly.sky.code.equals("SKY_O02") || hourly.sky.code.equals("SKY_O03") ||hourly.sky.code.equals("SKY_O07")){
                            rootView.setBackgroundResource(R.mipmap.bg_cloudy);
                        }else if (hourly.sky.code.equals("SKY_O04") || hourly.sky.code.equals("SKY_O06") || hourly.sky.code.equals("SKY_O08") || hourly.sky.code.equals("SKY_O10")){
                            rootView.setBackgroundResource(R.mipmap.bg_rainy);
                        }else if(hourly.sky.code.equals("SKY_O05") || hourly.sky.code.equals("SKY_O09")){
                            rootView.setBackgroundResource(R.mipmap.bg_snowy);
                        }else{
                            rootView.setBackgroundResource(R.mipmap.bg_lightening);
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Log.e("test", "");
            }
        });

    }

    void getForecast3Days(double latitude, double longitude) {
        APIService.getForecast3Days(1, String.valueOf(latitude), String.valueOf(longitude))
                .enqueue(new Callback<ForecastInfo>() {
                    @Override
                    public void onResponse(Call<ForecastInfo> call, Response<ForecastInfo> response) {
                        if (response.body() == null)
                            return;
                        ForecastInfo info = response.body();
                        if (info.weather == null || info.weather.forecast3days.isEmpty())
                            return;

                        ArrayList<SimpleForecast> forecastInfos = new ArrayList<>();

                        int offsetHour = 3;
                        int maxHour = 49;

                        Date today = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일 a hh시");

                        for (int hour = 4; hour <= maxHour; hour += offsetHour) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(today);
                            calendar.add(Calendar.HOUR, hour);

                            String time = sdf.format(calendar.getTime());
                            String sky = "";
                            String temp = "";

                            try {
                                Forecast3day forecast = info.weather.forecast3days.get(0);
                                Field skyField = forecast.fcst3hour.sky.getClass()
                                        .getField("name" + hour + "hour");
                                sky = skyField.get(forecast.fcst3hour.sky).toString();

                                Field tempField = forecast.fcst3hour.temperature.getClass()
                                        .getField("temp" + hour + "hour");
                                temp = tempField.get(forecast.fcst3hour.temperature).toString();

                                if (temp.isEmpty() == false)
                                    temp = String.valueOf((int) Double.parseDouble(temp)) + "℃";
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            forecastInfos.add(new SimpleForecast(time, sky, temp));
                        }
                        rvForecast.setHasFixedSize(true);

                        mForecastAdapter = new ForecastAdapter(forecastInfos);
                        rvForecast.setAdapter(mForecastAdapter);

                        mForecastAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<ForecastInfo> call, Throwable t) {

                    }
                });
    }

    @OnClick(R.id.btnAddCity)
    void showAddressDialog() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText etAddress = new EditText(this);

        etAddress.setSingleLine();
        alert.setTitle("지역 추가");
        alert.setMessage("주소를 입력하세요 \n(ex: 00시 00구 00동)");
        alert.setView(etAddress);
        alert.setPositiveButton("추가", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String address = etAddress.getText().toString();
                Address location = getLocationFromAddress(address);

                if(location == null){



                    Toast.makeText(MainActivity.this, "주소를 확인하세요 ,",
                    Toast.LENGTH_LONG).show();

                    return;

                }
                if(address == null)
                    return;
                String city;
                String[] temp = location.getAddressLine(0).split(" ");
                if(temp.length >=3) {
                    if(temp[0].equals("대한민국"))
                        city = temp[1] + " "+temp [2] + " " + temp [3];
                    else
                        city = temp[0] + " "+temp[1] + " "+ temp[2];
                }else{
                    city = location.getAddressLine(0);
                }
                    cities.add(city);
                ArrayAdapter adapter = (ArrayAdapter)lvCity.getAdapter();
                adapter.notifyDataSetChanged();

            }
        });
        alert.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.create().show();
    }
    @OnItemClick(R.id.lvCity)
    public void onCityItemClick(AdapterView<?> parent, int postion){
        updateCityWeather(postion);
    }
    public void updateCityWeather(int position) {
        Address location = getLocationFromAddress(cities.get(position));

        if(location == null)
            return;

        latitude = location.getLatitude();
        longitude = location.getLongitude();
        getCurrentWeather(latitude, longitude);
        getForecast3Days(latitude, longitude);

        tvLocation.setText(location.getAddressLine(0));
    }

    @OnItemLongClick(R.id.lvCity)
    public boolean onCityLongClick(AdapterView<?>parent, final int position){
        if(position ==0)
            return true;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("지역 삭제");
        builder.setMessage(cities.get(position) + " 을 삭제하시겠습니까?");
        builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cities.remove(position);

                ArrayAdapter adapter = (ArrayAdapter) lvCity.getAdapter();
                adapter.notifyDataSetChanged();

                updateCityWeather(0);
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();


        return true;
    }
}
