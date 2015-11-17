package damp_2.utad.actividad4_android_fernandosanchez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.quickblox.core.request.QBRequestGetBuilder;
import com.quickblox.customobjects.model.QBCustomObject;

import java.util.ArrayList;
import java.util.HashMap;

import damp_2.utad.milibreria.TaskAdmin.QBAdmin;
import damp_2.utad.milibreria.TaskAdmin.QBAdminListener;

public class MainActivity extends AppCompatActivity implements QBAdminListener {


    QBAdmin qbAdmin;
    HashMap<String,String> palabras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        palabras=new HashMap<String,String>();
        qbAdmin = new QBAdmin(getBaseContext());
        qbAdmin.addQbAdminListener(this);
        qbAdmin.simpleSession();

    }

    @Override
    public void simpleSessionCreated(boolean isCreated) {
        if(isCreated){
            Log.v("MainActivity","simpleSessionCreated" + isCreated);

            QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();
            requestBuilder.eq("idi", "en");
            qbAdmin.cargarTabla("TablaAct4Android",requestBuilder);
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

    @Override
    public void tablacargada(ArrayList<QBCustomObject> customObjects) {

        for(int i=0; i<customObjects.size(); i++){
            palabras.put(customObjects.get(i).getFields().get("ids").toString(),customObjects.get(i).getFields().get("valor").toString());
            ;
            //QBCustomObject qbcustmObj = new QBCustomObject();

           // int ids = customObjects.get(i).getUserId();
           // String idi = customObjects.get(i);
           // String valor = customObjects.getString();

        }

        Log.v("QuickBlox"," LA TABLA RESULTANTE ES: "+palabras.get("1")+"    "+palabras.get("2"));


    }
}
