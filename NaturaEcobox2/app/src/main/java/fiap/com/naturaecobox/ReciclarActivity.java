package fiap.com.naturaecobox;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class ReciclarActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ImageView imageView ;
    private Button btnScanear;
    private TextView txtQRResultado;

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove o statusbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_reciclar);

        imageView = (ImageView) findViewById(R.id.imgQRCode);
        btnScanear = (Button) findViewById(R.id.btnScanearQR);
        txtQRResultado = (TextView) findViewById(R.id.txtQRResultado);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA,
            }, 0);
        }
    }

    public void scanQR (View v){
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view<br />
        setContentView(mScannerView);
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.<br />
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {

        // Do something with the result here
        Log.e("", result.getText()); // Prints scan results
        Log.e("", result.getBarcodeFormat().toString()); // Prints the scan format (qrcode)
       // show the scanner result into dialog box.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(result.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();
        // If you would like to resume scanning, call this method below
        // mScannerView.resumeCameraPreview(this);
        //https://www.numetriclabz.com/android-qr-code-scanner-using-zxingscanner-library-tutorial/


    }
}
