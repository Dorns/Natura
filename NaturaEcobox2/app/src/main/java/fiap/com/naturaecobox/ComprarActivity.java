package fiap.com.naturaecobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComprarActivity extends AppCompatActivity {

    private Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);
        btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
    }

    public void confirmar (View v){
        Intent i = new Intent(this,FinalizarCompra.class);
        startActivity(i);
    }
}
