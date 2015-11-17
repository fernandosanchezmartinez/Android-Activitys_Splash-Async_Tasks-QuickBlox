package damp_2.utad.milibreria.TaskAdmin;

import com.quickblox.customobjects.model.QBCustomObject;

import java.util.ArrayList;

/**
 * Created by fernando.sanchez on 06/11/2015.
 */
public interface QBAdminListener {

    public void simpleSessionCreated(boolean isCreated);
    public void qbUserSessionCreated(boolean isCreated);
    public void chatUserCreated(boolean isCreated);
    public void tablacargada (ArrayList<QBCustomObject> customObjects);

}
