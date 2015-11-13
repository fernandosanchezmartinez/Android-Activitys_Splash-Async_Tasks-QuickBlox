package damp_2.utad.milibreria.TaskAdmin;

import android.content.Context;
import android.os.Bundle;


import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
import com.quickblox.core.QBEntityCallbackImpl;
import com.quickblox.core.QBSettings;
import com.quickblox.core.request.QBRequestGetBuilder;
import com.quickblox.customobjects.QBCustomObjects;
import com.quickblox.customobjects.model.QBCustomObject;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fernando.sanchez on 06/11/2015.
 */
public class QBAdmin {

    private QBAdminListener listener;


    private QBUser qbUser = null;
    private Context context;


   // private QBAdminListener listener;



    public QBAdmin(Context context) {
        this.context =context;

        QBSettings.getInstance().fastConfigInit("30679", "UBpAyQm-F6t4ER5", "BxSGKUDdzpeXWgd");
    }


    public void addQbAdminListener(QBAdminListener listener){
        this.listener=listener;
    }


    public void simpleSession(){
    QBAuth.createSession(new QBEntityCallbackImpl<QBSession>() {
        @Override
        public void onSuccess(QBSession session, Bundle params) {
            boolean sesionCreada = true;
            listener.simpleSessionCreated(sesionCreada);
            // success
        }

        @Override
        public void onError(List<String> errors) {
            boolean sesionCreada = false;
            listener.simpleSessionCreated(sesionCreada);
            // errors
        }
    });
    }

    public void cargarTabla(){

        QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();
        requestBuilder.eq("idi", "es");


        QBCustomObjects.getObjects("TablaAct4Andorid", requestBuilder, new QBEntityCallbackImpl<ArrayList<QBCustomObject>>() {
            @Override
            public void onSuccess(ArrayList<QBCustomObject> customObjects, Bundle params) {

                ArrayList<QBCustomObject> arlObj = customObjects;
                //QBCustomObject qbcustmObj = new QBCustomObject();

                //for(int i=1; arlObj; i++){
                //    QBCustomObject qbcustmObj = new QBCustomObject();


                //}

                //int ids = params.getInt();
              //  int ids = arlObj.get();
               // String idi = params.getString(arlObj.g);
               // String valor = params.getString(valor);
            }

            @Override
            public void onError(List<String> errors) {

            }
        });
    }
}
