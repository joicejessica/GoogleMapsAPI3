package a14.xiirpl3.joicejessica.googlemapsapi3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition MALANG = CameraPosition.builder()
            .target(new LatLng(-7.966620, -112.632632))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition JEMBER = CameraPosition.builder()
            .target(new LatLng(-8.184486, -113.668075))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition JAKARTA = CameraPosition.builder()
            .target(new LatLng(-6.175110, 106.865039))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition SOLO = CameraPosition.builder()
            .target(new LatLng(-7.575489, 110.824327))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMlg = findViewById(R.id.btnMlg);
        btnMlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(MALANG);
            }
        });

        Button btnJbr = findViewById(R.id.btnJbr);
        btnJbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(JEMBER);
            }
        });

        Button btnCpg = findViewById(R.id.btnCpg);
        btnCpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(JAKARTA);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        flyTo(SOLO);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

}