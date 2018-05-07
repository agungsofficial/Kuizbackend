package com.eostudio.kuizbackend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class DaftarActivity extends AppCompatActivity {

    EditText idu, pass;
    Button saveme;
    String ID, PWD;
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        content= (TextView)findViewById( R.id.txt_response);
        idu =    (EditText) findViewById( R.id.et_id_d );
        pass =    (EditText) findViewById( R.id.et_password_d );


    }

    public void onClick(View v)
    {
        try{

            // CALL GetText method to make post method call
            GetText();
        }
        catch(Exception ex)
        {
             content.setText(" url exeption! " );
        }
    }

    public  void  GetText()  throws UnsupportedEncodingException
    {
        // Get user defined values
        ID = idu.getText().toString();

        PWD   = pass.getText().toString();

        // Create data variable for sent values to server

        String data = URLEncoder.encode("id", "UTF-8")
                + "=" + URLEncoder.encode(ID, "UTF-8");
        data += "&" + URLEncoder.encode("passwd", "UTF-8")
                + "=" + URLEncoder.encode(PWD, "UTF-8");

        String text = "";
        BufferedReader reader=null;

        // Send data
        try
        {

            // Defined URL  where to send data
            URL url = new URL("mobprog.yuliadi.pro:5000/buat_account");

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        }
        catch(Exception ex)
        {

        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {}
        }

        // Show response on activity
        content.setText( text  );

    }
}
