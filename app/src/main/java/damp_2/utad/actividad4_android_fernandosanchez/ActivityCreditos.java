package damp_2.utad.actividad4_android_fernandosanchez;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import damp_2.utad.milibreria.TaskAdmin.TaskAdmin.TaskAdmin;
import damp_2.utad.milibreria.TaskAdmin.TaskAdmin.TaskAdminListener;

/**
 * Created by fernando.sanchez on 06/11/2015.
 */
public class ActivityCreditos extends AppCompatActivity implements TaskAdminListener{

    TaskAdmin taskAdmin;

    ImageView imagen1 = null;
    ImageView imagen2 = null ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        imagen1 = (ImageView) findViewById(R.id.androidlogo1);
        imagen2 = (ImageView) findViewById(R.id.cargando);

        taskAdmin = new TaskAdmin(10000, 1);
        taskAdmin.addQTaskAdminListener(this);

    }


    @Override
    public void taskCicloAcabado(int iNumOfCycles) {
        imagen1.setVisibility(View.GONE);
        imagen2.setVisibility(View.VISIBLE);
    }

    @Override
    public void taskTodosCiclosAcabados() {
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);

    }
}
