package com.example.ClubHub;

import com.google.android.gms.maps.GoogleMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScottMockito1 {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void loginSuccessUserTest() throws JSONException{

        LoginSuccess tester = mock(LoginSuccess.class);

        String userFetched = "svlasic";
        when(tester.fetchUser()).thenReturn(userFetched);
        Assert.assertEquals(tester.fetchUser(), "svlasic");

    }


    @Test
    public void registrationTest(){

        Registration tester = mock(Registration.class);

        ArrayList<String> list = new ArrayList<>();

        String netID = "396332961";
        String id = "svlasic";
        String fName = "Scott";
        String lName = "Vlasic";
        String classification = "junior";
        String phone = "949-370-4160";
        String major = "CPRE";
        String pass = "1234";

        when (tester.regCreds(netID, id, fName, lName, classification, phone, major, pass)).thenReturn(list);

        Assert.assertEquals(tester.regCreds(netID, id, fName, lName, classification, phone, major, pass), list);
    }

    @Test
    public void loginTest(){

        Login tester = mock(Login.class);

        ArrayList<String> list = new ArrayList<>();

        String user = "svlasic";
        String pass = "1234";

        when(tester.loginCredentials(user,pass)).thenReturn(list);

        Assert.assertEquals(tester.loginCredentials(user,pass), list);
    }


}

