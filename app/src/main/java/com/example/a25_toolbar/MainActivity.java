package com.example.a25_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MenuItem mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //액션바의 단점
        //커스텀이 힘듬, 레이아웃에 없음, 코드를 수정하거나 테마를 직접 수정해야함.
        //액션바를 쓰려면 테마에서 NoActionBar 를 해줘야함

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
//        코드에서 액션바를 써야한다면
//        getSupportActionBar() 불러와서 설정해주면 됨.
        SearchView searchView = findViewById(R.id.search_view);
        //메뉴 달아주려고 gone 해놨음
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //검색어를 입력하고 확인을 누르면 이벤트를 받음
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            //검색어를 입력하는 동안 계속 이벤트를 받음.
            public boolean onQueryTextChange(String newText) {
                Log.d("Main", "onQueryTextChange: " + newText);
                return true;
            }
        });

    }
    //메뉴에서 서치뷰 달기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        //메뉴아이템 가져오기.
        MenuItem search = menu.findItem(R.id.action_search);
        android.widget.SearchView searchView = (android.widget.SearchView) search.getActionView();
        searchView.setQueryHint("메롱메롱");
        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("Main", "onQueryTextChange: " + newText);

                return true;
            }
        });
        return true;
    }

}