package fiap.com.naturaecobox;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView btnComprar;
    private ImageView btnReciclar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove o statusbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        btnComprar = (ImageView) findViewById(R.id.btnComprar);
        btnReciclar = (ImageView) findViewById(R.id.btnReciclar);




    }

    public void comprar (View v){
        Intent i = new Intent(this,ComprarActivity.class);
        startActivity(i);
    }

    public void reciclar (View v){
        Intent i = new Intent(this,ReciclarActivity.class);
        startActivity(i);
    }

}
