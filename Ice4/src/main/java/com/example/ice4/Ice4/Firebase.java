package com.example.ice4.Ice4;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.io.FileInputStream;

public class Firebase {
    public void init() {
        try {
            FileInputStream serviceAccount =
                    new
                            FileInputStream("src/main/resources/sabreops-f4d9b-firebase-admi
                            nsdk-fbsvc-54ffc785e5.json");
                            FirebaseOptions options = FirebaseOptions.builder()

                            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                            .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            System.out.println("Firebase has been initialized!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
