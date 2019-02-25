package com.example.everis.android.androidbasicoaplicado;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by rillanga on 20/6/18.
 */

public class MyAsyncTask extends AsyncTask<Void, Integer, Boolean> {

    private ProgressDialog pDialog;
    private Activity mActivity;

    public MyAsyncTask(Activity activity) {
        mActivity = activity;
    }

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(mActivity);
        pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pDialog.setMessage("Procesando...");
        pDialog.setCancelable(true);
        pDialog.setMax(100);
        pDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                MyAsyncTask.this.cancel(true);
            }
        });
        pDialog.setProgress(0);
        pDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        for(int i=1; i<=10; i++) {
            tareaLarga();

            publishProgress(i*10);

            if(isCancelled())
                break;
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progreso = values[0].intValue();

        pDialog.setProgress(progreso);
    }


    @Override
    protected void onPostExecute(Boolean result) {
        if(result)
        {
            pDialog.dismiss();
            Toast.makeText(mActivity, "Tarea finalizada!",
                Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCancelled() {
        Toast.makeText(mActivity, "Tarea cancelada!",
            Toast.LENGTH_SHORT).show();
    }

    private void tareaLarga()
    {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}
    }

}
