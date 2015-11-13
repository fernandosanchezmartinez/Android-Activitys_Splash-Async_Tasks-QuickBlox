package damp_2.utad.milibreria.TaskAdmin;

/**
 * Created by fernando.sanchez on 06/11/2015.
 */
public interface QBAdminListener {

    public void simpleSessionCreated(boolean isCreated);
    public void qbUserSessionCreated(boolean isCreated);
    public void chatUserCreated(boolean isCreated);

}
