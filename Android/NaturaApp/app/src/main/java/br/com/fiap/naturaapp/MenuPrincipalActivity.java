package br.com.fiap.naturaapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import layout.ComprarFragment;
import layout.PerfilUsuarioFragment;
import layout.RetornarEmbalagemFragment;

public class MenuPrincipalActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lstMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        lstMenu = (ListView) findViewById(R.id.lstMenu);
        lstMenu.setAdapter(new ArrayAdapter(this, R.layout.list_white_text,
                R.id.list_content,  getResources().getStringArray(R.array.menuLateral)));

        lstMenu.setOnItemClickListener(this);
        mostrarPerfil();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (position == 0) {
            mostrarPerfil();
        } else if (position == 1) {
            comprar();
        } else if (position == 2) {
            retornarEmbalagem();
        }else{
            finish();
        }
        ((DrawerLayout) findViewById(R.id.activity_menu_principal)).closeDrawers();
    }

    public void mostrarPerfil(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.frame, new PerfilUsuarioFragment());
        t.commit();
    }

    public void comprar(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.frame, new ComprarFragment());
        t.commit();
    }

    public void retornarEmbalagem(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.frame, new RetornarEmbalagemFragment());
        t.commit();
    }

}
