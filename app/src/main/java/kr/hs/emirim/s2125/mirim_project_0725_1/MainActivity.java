package kr.hs.emirim.s2125.mirim_project_0725_1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    ActionBar.Tab tab1, tab2, tab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        tab1 = bar.newTab();
        tab1.setText("변백현");
        tab1.setTabListener(this);
        bar.addTab(tab1);
        
        tab2 = bar.newTab();
        tab2.setText("오세훈");
        tab2.setTabListener(this);
        bar.addTab(tab2);
        
        tab3 = bar.newTab();
        tab3.setText("김준면");
        tab3.setTabListener(this);
        bar.addTab(tab3);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}