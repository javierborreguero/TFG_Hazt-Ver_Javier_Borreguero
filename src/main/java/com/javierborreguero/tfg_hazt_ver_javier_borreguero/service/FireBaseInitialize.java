package com.javierborreguero.tfg_hazt_ver_javier_borreguero.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FireBaseInitialize {
    private static final Logger LOGGER = LoggerFactory.getLogger(FireBaseInitialize.class);

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream("./serviceaccount.json");
            FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://chatapp-e6e15.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(firebaseOptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
