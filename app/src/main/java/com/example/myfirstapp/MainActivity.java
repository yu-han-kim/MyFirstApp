package com.example.myfirstapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    static RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.xeditText);
        textView = findViewById(R.id.XtextView);

        Button button = findViewById(R.id.Xbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest();
            }
        });
        if (requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(getApplicationContext());

            }
        public void makeRequest(){
            String url = editText.getText().toString();
            StringRequest request = new StringRequest(Request.Methood.GET, url, new Response.Listner<String>() {
                @Override
                public void onResponse(String response) {
                    printIn("응답"-> "+response");
                    procassResponse(response);

                }
            }
            new Response.ErrorListner() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    printIn("에러"-> "+error.getMessage");

                }
            }
        }
    }{
        @Override
                protected Map<String, String> getParams() throws AuthFailureError{
            Map<String, String> params = new HashMap<~>();

            return params;
        }
    };

    request.setShouldCache(false);
    requestQueue.add(request);
    printIn("요청 보냄,");


    private void makeRequest() {
    }

    public void OnClicktoMeg(View v) {
        Toast.makeText(this, "19273026", Toast.LENGTH_SHORT).show();
    }

    public void procassResponse(String response)
    {
        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(response, MovieList.class);
        PrintIn("영화 정보의 수 : "+movieList.boxofficeResult.dailyBoxOfficeList.size());
    }
}
