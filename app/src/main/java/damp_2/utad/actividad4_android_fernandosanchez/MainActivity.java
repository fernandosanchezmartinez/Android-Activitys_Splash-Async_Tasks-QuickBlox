package damp_2.utad.actividad4_android_fernandosanchez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import damp_2.utad.milibreria.TaskAdmin.QBAdmin;
import damp_2.utad.milibreria.TaskAdmin.QBAdminListener;

public class MainActivity extends AppCompatActivity implements QBAdminListener {


    QBAdmin qbAdmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qbAdmin = new QBAdmin(getBaseContext());
        qbAdmin.addQbAdminListener(this);
        qbAdmin.simpleSession();

    }

    @Override
    public void simpleSessionCreated(boolean isCreated) {
        if(isCreated){
            Log.v("MainActivity","simpleSessionCreated" + isCreated);
        }
    }

    @Override
    public void qbUserSessionCreated(boolean isCreated) {
        if(isCreated){
            Log.v("MainActivity","qbUserSessionCreated"+ isCreated);
        }
    }

    @Override
    public void chatUserCreated(boolean isCreated) {
        if(isCreated){
            Log.v("MainActivity","chatUserCreated"+ isCreated);
        }
    }
}
