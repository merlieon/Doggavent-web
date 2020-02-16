package com.example.doggamore.services;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.doggamore.handlers.HttpHandler;
import com.example.doggamore.models.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    HttpHandler httpHandler = new HttpHandler();

    // Getting all users to list
    public List<User> getAllUsers() throws IOException, JSONException {
        String url = "https://doggavent.herokuapp.com/api/json/users";
        JSONArray userResponse = new JSONArray(httpHandler.httpGetConnection(url).toString());
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < userResponse.length(); i++) {
            String userName = userResponse.getJSONObject(i).getString("username");
            userList.add(new User(userName));
            System.out.println(userName);
        }
        return userList;
    }


}
