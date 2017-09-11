package fiap.com.naturaecobox;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class FinalizarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    private TextView txtMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove o statusbar , tem q ficar em primeiro
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtMensagem = (TextView) findViewById(R.id.txtMensagem);

        //Recupera informações da activity
        Bundle param = getIntent().getExtras();
        String msg = param.getString("msg");
        String acao = param.getString("acao");

        Log.i("","mssa:"+msg);

        //Atribui os valores para mensagem e URL JSON


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.INTERNET,
            }, 0);
        }
        enviaReq("acaodasdasda");
    }




    public void enviaReq(String acao){

        final String URL = "http://192.168.1.33:1880/natura";
        JSONObject param = new JSONObject();

        try {
            param.put(acao,"abrir");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue reqQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonReq = new JsonObjectRequest(URL,param,this,this);
        reqQueue.add(jsonReq);
        setContentView(R.layout.activity_finalizar);

    }

    public void finalizar(View v){
        txtMensagem.set;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
    }

    @Override
    public void onResponse(JSONObject response) {

    }


}
