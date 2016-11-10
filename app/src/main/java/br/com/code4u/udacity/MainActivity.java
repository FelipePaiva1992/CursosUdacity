package br.com.code4u.udacity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.com.code4u.udacity.model.CatalgoUdacity;
import br.com.code4u.udacity.model.Courses;
import br.com.code4u.udacity.service.UdacityServicos;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<CatalgoUdacity> {

    private static final String TAG = "code4u";
    CatalgoUdacity catalgoUdacity;

    @BindView(R.id.listaCursos)
    ListView listaCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(UdacityServicos.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UdacityServicos servico = retrofit.create(UdacityServicos.class);
        Call<CatalgoUdacity> call = servico.listaCatalogo();

        //chamada assincrona
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<CatalgoUdacity> call, Response<CatalgoUdacity> response) {

        if(response.isSuccessful()){
            catalgoUdacity = response.body();
            populaAdapterCursos();
        }else{
            Log.e(TAG,"Erro : " + response.code());
            Toast.makeText(this,response.code(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<CatalgoUdacity> call, Throwable t) {
        Log.e(TAG,"Erro : " + t.getMessage());
        Toast.makeText(this,t.getMessage(),Toast.LENGTH_SHORT).show();
    }

    private void populaAdapterCursos(){
        ArrayAdapter<Courses> itemsAdapter = new ArrayAdapter<Courses>(this,android.R.layout.simple_list_item_1,catalgoUdacity.getCourses());
        listaCursos.setAdapter(itemsAdapter);
    }
}
