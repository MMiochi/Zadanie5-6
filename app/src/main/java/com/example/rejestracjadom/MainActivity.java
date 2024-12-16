package com.example.rejestracjadom;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView likesTextView;
    private Button likeButton;
    private Button deleteButton;
    private Button checkUserButton;
    private Button confirmButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private TextView notificationTextView;
    private int likeCount = 0;
    private String loggedInEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.Email);
        passwordEditText = findViewById(R.id.Password);
        confirmPasswordEditText = findViewById(R.id.Password2);
        notificationTextView = findViewById(R.id.Notifications);
        confirmButton = findViewById(R.id.Confirm);
        likeButton = findViewById(R.id.Like);
        checkUserButton = findViewById(R.id.CheckUser);
        deleteButton = findViewById(R.id.Delete);
        likesTextView = findViewById(R.id.Likes);

        likeButton.setOnClickListener(v -> incrementLikes());

        deleteButton.setOnClickListener(v -> decrementLikes());

        confirmButton.setOnClickListener(v -> confirmUser());

        checkUserButton.setOnClickListener(v -> checkUser());
    }

    private void confirmUser() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        if (!email.contains("@")) {
            notificationTextView.setText("Nieprawidłowy adres e-mail");
        } else if (!password.equals(confirmPassword)) {
            notificationTextView.setText("Hasła się różnią");
        } else {
            loggedInEmail = email;
            notificationTextView.setText("Zalogowano jako " + email);
        }
    }

    private void checkUser() {
        if (loggedInEmail.isEmpty()) {
            notificationTextView.setText("Nie jesteś zalogowany");
        } else {
            notificationTextView.setText("Zalogowany użytkownik: " + loggedInEmail);
        }
    }

    private void updateLikesDisplay() {
        likesTextView.setText(likeCount + " polubień");
    }

    private void incrementLikes() {
        likeCount++;
        updateLikesDisplay();
    }

    private void decrementLikes() {
        if (likeCount > 0) {
            likeCount--;
            updateLikesDisplay();
        }
    }
}