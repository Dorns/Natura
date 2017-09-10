package fiap.com.naturaecobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ComprarActivity extends AppCompatActivity {

    private Button btnConfirmar;
    private EditText edtCodigo;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove o statusbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_comprar);
        btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        edtCodigo = (EditText) findViewById(R.id.edtCodigo);
        img = (ImageView) findViewById(R.id.img);

        edtCodigo.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    buscarProduto();
                    return true;
                }
                return false;
            }
        });



    }

    private void buscarProduto() {
        if (edtCodigo.getText().toString().equals("12345")){
            img.setImageResource(R.drawable.kaiak);
            btnConfirmar.setVisibility(View.VISIBLE);
        }else{
            img.setImageResource(R.drawable.logo);
            btnConfirmar.setVisibility(View.INVISIBLE);
            Toast.makeText(this,"Cofigo inválido",Toast.LENGTH_LONG).show();
        }

    }

    public void confirmar (View v){
        Intent i = new Intent(this,FinalizarActivity.class);
        i.putExtra("acao","comprar");
        i.putExtra("msg","Retire seu produto");
        startActivity(i);


    }
}
