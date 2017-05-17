package br.com.fiap.naturaapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import layout.PerfilUsuarioFragment;

public class MenuPrincipalActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

   // private FrameLayout frame;
    private ListView lstMenu;
    private LinearLayout DrawerLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

    //    frame = (FrameLayout) findViewById(R.id.frame);
        lstMenu = (ListView) findViewById(R.id.lstMenu);
        lstMenu.setOnItemClickListener(this);
        mostrarPerfil();
    }

    public void PerfilUsuario(View v){
        mostrarPerfil();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Log.i("dasdasdokasopdkasop", "onItemClick: apsdkasopdkasopdkasop");

        ((DrawerLayout) findViewById(R.id.activity_menu_principal)).closeDrawer(lstMenu);

    }

    public void mostrarPerfil(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.frame, new PerfilUsuarioFragment());
        t.commit();
    }

}
