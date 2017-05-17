package br.com.fiap.naturaapp;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MenuPrincipalActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private FrameLayout frame;
    private ListView lstMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        frame = (FrameLayout) findViewById(R.id.frame);
        lstMenu = (ListView) findViewById(R.id.lstMenu);
        lstMenu.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (position == 0 ){
           // mostrarCC();
        }else if (position == 1){
           // mostrarAplicacao();
        }else{
            finish();
        }

        ((DrawerLayout) findViewById(R.id.activity_menu_principal)).closeDrawer(lstMenu);


    }
}
