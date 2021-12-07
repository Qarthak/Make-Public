package androidsamples.java.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.Executor;


public class LoginFragment extends Fragment {

    private static final String TAG = "LoginFragment";
    private NavController mNavController;

    FirebaseAuth mAuth;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);



        view.findViewById(R.id.btn_log_in)
                .setOnClickListener(v -> {
                    // TODO implement sign in logic
                    TextView emailBox=view.findViewById(R.id.edit_email);
                    TextView passwordBox=view.findViewById(R.id.edit_password);
                    String email= String.valueOf(emailBox.getText());
                    String password= String.valueOf(passwordBox.getText());

                    FirebaseDatabase mFirebaseDatabase=FirebaseDatabase.getInstance();
//                    DatabaseReference myRefEmail=mFirebaseDatabase.getReference(email);


					//Check if email already exists in Firebase

                    try {
                        mAuth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(task -> {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        NavDirections action = LoginFragmentDirections.actionLoginSuccessful();
                                        Navigation.findNavController(v).navigate(action);

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());


                                    }
                                });
                    }
                    catch (Exception e){
                        Log.d(TAG,"Already exists");
                    }
//                    mAuth.signInWithEmailAndPassword(email, password)
//                            .addOnCompleteListener(
//                                    new OnCompleteListener<AuthResult>() {
//                                        @Override
//                                        public void onComplete(
//                                                @NonNull Task<AuthResult> task)
//                                        {
//                                            if (task.isSuccessful()) {
//
//                                                // hide the progress bar
//                                                Log.d(TAG,"Task suc");
//
//                                                // if sign-in is successful
//                                                // intent to home activity
////                                                Intent intent
////                                                        = new Intent();
////                                                startActivity(intent);
//                                            }
//
//                                            else {
//                                                // sign-in failed
//                                                Log.d(TAG,"Dasdsa");
//                                            }
//                                        }
//                                    });




                });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // TODO if a user is logged in, go to Dashboard

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            mNavController = Navigation.findNavController(view);
            mNavController.navigate(LoginFragmentDirections.actionLoginSuccessful());
        }
    }

    // No options menu in login fragment.
}