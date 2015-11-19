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

    ActivityCreditosUI acui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        acui = new ActivityCreditosUI(this);

        taskAdmin = new TaskAdmin(2000, 2);
        taskAdmin.addQTaskAdminListener(this);
        taskAdmin.startTasks();

        imagen1 = (ImageView) findViewById(R.id.androidlogo1);
        imagen2 = (ImageView) findViewById(R.id.cargando);



    }


    @Override
    public void taskCicloAcabado(int iNumOfCycles) {
       // imagen1.setVisibility(View.GONE);
       // imagen2.setVisibility(View.VISIBLE);
        runOnUiThread(acui);
    }

    @Override
    public void taskTodosCiclosAcabados() {
       // Intent i = new Intent(this, MainActivity.class );
      //  startActivity(i);
       // finish();

        runOnUiThread(acui);

    }
}
