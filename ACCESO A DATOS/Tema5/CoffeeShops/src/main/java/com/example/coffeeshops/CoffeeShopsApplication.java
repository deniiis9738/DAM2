package com.example.coffeeshops;

import com.google.api.gax.rpc.ApiException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class CoffeeShopsApplication {
    private static Firestore database;
    private static Bucket bucket;


    public static void main(String[] args) {
        inicializarFirebase();

        // Replace "CoffeeShops" with the actual name of your collection
        CollectionReference coffeeShopsCollection = database.collection("CoffeeShops");

        try {
            // Retrieve all documents from the "CoffeeShops" collection
            QuerySnapshot querySnapshot = coffeeShopsCollection.get().get();

            for (QueryDocumentSnapshot document : querySnapshot) {
                // Assuming there's a field named "imageURL" in each document containing the image URL
                String imageUrl = document.getString("imageURL");

                if (imageUrl != null) {
                    // You can now use the imageURL to display or process the image
                    System.out.println("Image URL: " + imageUrl);
                } else {
                    System.out.println("No image URL found for document: " + document.getId());
                }
            }
        } catch (ApiException e) {
            // Handle exceptions here
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void inicializarFirebase() {
        try {
            FileInputStream serviceAccount = new FileInputStream("xat-ad-9f901-firebase-adminsdk-f1vja-ee7dc206de.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setProjectId("xat-ad-9f901")
                    .build();

            FirebaseApp.initializeApp(options);

            FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setProjectId("xat-ad-9f901")
                    .build();

            database = firestoreOptions.getService();
            bucket = StorageOptions.getDefaultInstance().getService().get("xat-ad-9f901.appspot.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
