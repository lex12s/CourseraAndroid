package lexgame.com.petragramcursocoursera.emailsender;

import android.os.AsyncTask;

/**
 * Created by Conba on 26/06/2016.
 */
public class EmailSender extends AsyncTask<String,Void,Boolean> {
    @Override
    protected Boolean doInBackground(String... data) {

        String emailSenderAddress=(String)data[0];
        String emailSenderPassword=(String)data[1];
        String recipients=(String)data[2];
        String subject=(String)data[3];
        String comments=(String)data[4];
        String pictureFileName=(String)data[5];

        Email m = new Email(emailSenderAddress,emailSenderPassword);

        m.setTo(recipients);
        m.setFrom(emailSenderAddress);
        m.setSubject(subject);
        m.setBody(comments);

        try {
            ///m.addAttachment("/sdcard/filelocation");
            m.setPictureFileName(pictureFileName);
            return m.send();
        }
        catch (Exception e ) {
            //Toast.makeText(MainActivity.this, "There was a problem sending the email." + e.getMessage(), Toast.LENGTH_LONG).show();
            //throw  new Exception("Error sending ")
            throw new RuntimeException("Bang");
            //throw new RuntimeException(e);


        }


    }

    @Override
    protected void onPostExecute(Boolean result) {

    }
}
