package damp_2.utad.actividad4_android_fernandosanchez;

import android.content.Intent;
import android.view.View;

/**
 * Created by fernando.sanchez on 13/11/2015.
 */
public class ActivityCreditosUI implements Runnable {

    ActivityCreditos ca;

    static int I_SPLASH1_VISIBLE = 0;
    static int I_SPLASH2_VISIBLE = 1;
   // static int I_SPLASH2_VISIBLE = 1;

    int iEstado = I_SPLASH1_VISIBLE;



    public ActivityCreditosUI(ActivityCreditos ca){
        this.ca=ca;
    }


    @Override
    public void run(){

        if(I_SPLASH1_VISIBLE == iEstado){

            ca.imagen1.setVisibility(View.GONE);
            ca.imagen2.setVisibility(View.VISIBLE);

            iEstado = I_SPLASH2_VISIBLE;
        }else if (I_SPLASH2_VISIBLE == iEstado){

            Intent i = new Intent(ca,MainActivity.class);
            ca.startActivity(i);
            ca.finish();

        }
    }

}
