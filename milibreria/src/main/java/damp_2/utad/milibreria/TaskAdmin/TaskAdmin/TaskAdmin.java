package damp_2.utad.milibreria.TaskAdmin.TaskAdmin;

import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by fernando.sanchez on 06/11/2015.
 */
public class TaskAdmin extends TimerTask {
    private TaskAdminListener listener;
    private static long SPLASH_SCREEN_DELAY = 3000;// 10 seg
    private int iNumOfCycles=2;// un ciclo por imagen
    private Timer timer = null;
    //private TimerTask task = new TimerTask();

    public TaskAdmin(long delay, int numOfCycles){
        SPLASH_SCREEN_DELAY=delay;
        iNumOfCycles=numOfCycles;
        timer = new Timer();
}

    public void addQTaskAdminListener(TaskAdminListener listener){
        this.listener=listener;
    }

    public void startTasks(){
        timer.schedule(this, SPLASH_SCREEN_DELAY,SPLASH_SCREEN_DELAY);
    }
    public void setTasksAdminListener(TaskAdminListener listener){
        this.listener=listener;
    }

    @Override
    public void run() {

        iNumOfCycles--;

        //if(listener!=null)listener.taskCicloAcabado(iNumOfCycles);

        if(iNumOfCycles==0){
            timer.cancel();
            if(listener!=null)listener.taskTodosCiclosAcabados();
        }else if(listener!=null)listener.taskCicloAcabado(iNumOfCycles);
}}
