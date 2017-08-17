package adish333.rajasthantour;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HomeItemAdapter adapter;
    private List<HomeItem> albumList;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    Intent i = new Intent(Home.this, Explore.class);
                    startActivity(i);
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);

        albumList = new ArrayList<>();
        adapter = new HomeItemAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new Explore.GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums();
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.gray2,
                R.drawable.kota,
                R.drawable.udaipur,
                R.drawable.jodhpur,
                R.drawable.kota,
                R.drawable.chittor,
                R.drawable.album1,
                R.drawable.chittor,
        };

        HomeItem a = new HomeItem("About Rajasthan", covers[0]);
        albumList.add(a);

        HomeItem b = new HomeItem("Quick QR Scan", covers[0]);
        albumList.add(b);
        HomeItem c = new HomeItem("Luxury on Wheels", covers[0]);
        albumList.add(c);
        HomeItem d = new HomeItem("Heritage Hotels", covers[0]);
        albumList.add(d);
        HomeItem e = new HomeItem("virtual Tour", covers[0]);
        albumList.add(e);
        HomeItem f = new HomeItem("Festivals", covers[0]);
        albumList.add(f);

        adapter.notifyDataSetChanged();
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
