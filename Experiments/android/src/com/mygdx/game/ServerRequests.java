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



    public void putJsonResponse(final HexTile hex) {
        JSONObject parms = null;
        parms = new JSONObject();
        try {
            parms.put("id", hex.order);
            parms.put("centerX", hex.centerX);
            parms.put("centerY", hex.centerY);
            parms.put("hasPlayer", hex.hasPlayer());
            parms.put("new", false);
        }
        catch(JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest req = new JsonObjectRequest(Request.Method.PUT,
                "http://coms-309-jr-6.misc.iastate.edu:8080/tiles/" + hex.order, parms,
                new Response.Listener<JSONObject>(){

                    public void onResponse(JSONObject response){
                        Log.d(TAG, response.toString());

                        /*try{
                            response.put("id", hex.order);
                            response.put("centerX", hex.getCenterX());
                            response.put("centerY", hex.getCenterY());
                            response.put("hasPlayer", hex.hasPlayer());
                            response.put("new", false);
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }*/
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                error.printStackTrace();
            }

        });
        {
            AppController.getInstance().addToRequestQueue(req, tag_req_obj);
        }
    }

    public void setJsonResponse(final HexTile hex){
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,
                "http://coms-309-jr-6.misc.iastate.edu:8080/tiles/" + hex.order, null,
                new Response.Listener<JSONObject>(){

                    public void onResponse(JSONObject response){
                        Log.d(TAG, response.toString());

                        try{
                            response.put("centerX", hex.getCenterX());
                            response.put("centerY", hex.getCenterY());
                            response.put("hasPlayer", hex.hasPlayer());
                            response.put("new", false);
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
        });
        {
            AppController.getInstance().addToRequestQueue(req, tag_req_obj);
        }
    }

    public void makeJsonObjReq(final int id) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                "http://coms-309-jr-6.misc.iastate.edu:8080/tiles/" + id, null,
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
