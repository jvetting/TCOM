package com.mygdx.game;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.mygdx.game.app.AppController;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerRequests extends Activity{

    private String TAG = ServerRequests.class.getSimpleName();
    private TextView msgResponse;
    private String tag_req_obj = "jobr_req";
    private String jsonResponse;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.json_request);
        msgResponse = findViewById(R.id.msgResponse);


    }

    public void putJsonResponse(HexTile hex){
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                "http://coms-309-jr-6.misc.iastate.edu:8080/tiles/new", null,
                new Response.Listener<JSONObject>(){

                    public void onResponse(JSONObject response){
                        log.d(TAG, response.toString());

                        try{
                            response.put("id", hex.order);
                            response.put("centerX", hex.getCenterX());
                            response.put("centerY", hex.getCenterY());
                            response.put("hasPlayer", hex.hasPlayer());
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                error.printStackTrace();
            }

        })
    }

    public void setJsonResponse(HexTile hex){
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                "http://coms-309-jr-6.misc.iastate.edu:8080/tiles/new/" + hex.order, null,
                new Response.Listener<JSONObject>(){

                    public void onResponse(JSONObject response){
                        log.d(TAG, response.toString());

                        try{
                            response.setInt("centerX", hex.getCenterX());
                            response.setInt("centerY", hex.getCenterY());
                            response.setBoolen("hasPlayer", hex.hasPlayer());
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
            error.printStackTrace();
        }

    })
    }

    public void makeJsonObjReq() {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                "http://coms-309-jr-6.misc.iastate.edu:8080/tiles/2", null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        try {
                            Integer id = (Integer) response.get("id");
                            int centerX = response.getInt("centerX");
                            int centerY = response.getInt("centerY");
                            boolean hasPlayer = response.getBoolean("hasPlayer");

                            jsonResponse = "";
                            jsonResponse += "id: " + id + "\n\n";
                            jsonResponse += "centerX: " + centerX + "\n\n";
                            jsonResponse += "centerY: " + centerY + "\n\n";
                            jsonResponse += "hasPlayer: " + hasPlayer + "\n\n";
                            Log.d(TAG, jsonResponse);
                            Main.hex[id].centerX = centerX;
                            Main.hex[id].centerY = centerY;
                            Main.hex[id].reference = 3;
                            if (Main.hex[id].character == null && hasPlayer){
                                Main.hex[id].character = new Npc();
                            }
                            else if (!hasPlayer){
                                Main.hex[id].character = null;
                            }
                            //msgResponse.setText(jsonResponse);

                        }
                        catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }

                        //msgResponse.setText(response.toString());
                        //callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                error.printStackTrace();
            }

        })
        {

            /**
             * Passing some request headers
             *
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Androidhive");
                params.put("email", "abc@androidhive.info");
                params.put("pass", "password123");

                return params;
            }
            */


        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_req_obj);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }
}
