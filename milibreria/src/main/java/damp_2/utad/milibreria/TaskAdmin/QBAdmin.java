package damp_2.utad.milibreria.TaskAdmin;

import android.content.Context;
import android.os.Bundle;

import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
import com.quickblox.core.QBEntityCallbackImpl;
import com.quickblox.core.QBSettings;
import com.quickblox.users.model.QBUser;

import java.util.List;

/**
 * Created by fernando.sanchez on 06/11/2015.
 */
public class QBAdmin {

    private QBAdminListener listener;

    private QBUser qbUser = null;
    private Context context;


   // private QBAdminListener listener;



    public void addQbAdminListener(QBAdminListener listener){
        this.listener=listener;
    }

    public QBAdmin(Context context) {
         this.context =context;

        QBSettings.getInstance().fastConfigInit("30679", "UBpAyQm-F6t4ER5", "BxSGKUDdzpeXWgd");
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
}
