package fiap.com.naturaecobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnComprar;
    private Button btnReciclar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComprar = (Button) findViewById(R.id.btnComprar);
        btnReciclar = (Button) findViewById(R.id.btnReciclar);
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
