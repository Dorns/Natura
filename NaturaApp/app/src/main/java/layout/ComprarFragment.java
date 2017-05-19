package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.fiap.naturaapp.R;


public class ComprarFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //v = tela do fragment
        View v = inflater.inflate(R.layout.fragment_comprar, container, false);
        return v;
    }


    @Override
    public void onClick(View view) {

    }





}
