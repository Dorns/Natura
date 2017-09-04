package fiap.com.naturaecobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ComprarActivity extends AppCompatActivity {

    private Button btnConfirmar;
    private EditText edtCodigo;
    private ImageView imgProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);
        btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        edtCodigo = (EditText) findViewById(R.id.edtCodigo);
        imgProduto = (ImageView) findViewById(R.id.imgProduto);
    }

    public void confirmar (View v){


        if (edtCodigo.getText().toString().equals("12345")){
            imgProduto.setVisibility(View.VISIBLE);
            imgProduto.setImageResource(R.drawable.kaiak);
            //Intent i = new Intent(this,FinalizarCompra.class);
            //startActivity(i);

        }else{
            imgProduto.setVisibility(View.INVISIBLE);
            Toast.makeText(this,"Cofigo inválido",Toast.LENGTH_LONG).show();

        }


    }
}
