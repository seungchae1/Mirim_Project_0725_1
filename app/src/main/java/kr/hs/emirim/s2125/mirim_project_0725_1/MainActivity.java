package kr.hs.emirim.s2125.mirim_project_0725_1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    ActionBar.Tab tab1, tab2, tab3;
    MyFragment[] myFrags = new MyFragment[3];

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
        MyFragment selectedFragment = null;
        if(myFrags[tab.getPosition()]==null){
            selectedFragment = new MyFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            selectedFragment.setArguments(data);
            myFrags[tab.getPosition()] = selectedFragment;
        }else{
            selectedFragment = myFrags[tab.getPosition()];
        }
        ft.replace(android.R.id.content, selectedFragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
    public static class MyFragment extends Fragment{
        String tabName;
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout layout = new LinearLayout(super.getActivity());
            layout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layout.setLayoutParams(params);
            layout.setGravity(Gravity.CENTER);
            ImageView imageview = new ImageView(super.getActivity());
            layout.addView(imageview);
            if(tabName.equals("변백현")){
                layout.setBackgroundColor(Color.BLUE);
                imageview.setImageResource(R.drawable.bbk);
            }
            else if(tabName.equals("오세훈")){
                layout.setBackgroundColor(Color.YELLOW);
                imageview.setImageResource(R.drawable.osh);
            }
            else if(tabName.equals("김준면")){
                layout.setBackgroundColor(Color.MAGENTA);
                imageview.setImageResource(R.drawable.kjm);
            }
            return layout;
        }
    }
}