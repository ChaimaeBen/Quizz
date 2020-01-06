package com.example.quizz;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizz.Database.repository.userRepository;
import com.example.quizz.dummy.RandomString;
import com.example.quizz.models.User;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class ProfileFragment extends Fragment {

private TextView first,email,last,high;
private ImageView pic;
    userRepository rep;
private User u;
    public ProfileFragment() {
        // Required empty public constructor
    }


     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         rep = new userRepository(getActivity().getApplication());

        SharedPreferences A= getActivity().getSharedPreferences("MySharedPref",MODE_PRIVATE);
         SharedPreferences Az= getActivity().getSharedPreferences("highPref",MODE_PRIVATE);

        View view= inflater.inflate(R.layout.fragment_profile, container, false);





       pic = view.findViewById(R.id.id_profilePic);


         new Thread(new Runnable() {
             @Override
             public void run() {
                 final FetchAvatarAsyncTask task = new FetchAvatarAsyncTask();
                 task.execute(pic);
             }
         }).start();


        String em = A.getString("email", "");


User u =rep.getScoreUser(em);
         int highscore = u.getNewHigh();
u = rep.getUserEmail(em);
    String fi= u.getFirstname();
   String ls=  u.getLastname();

         first = view.findViewById(R.id.id_firstname);
        email = view.findViewById(R.id.id_email);
        last = view.findViewById(R.id.id_lastname);
     high = view.findViewById(R.id.id_high);
System.out.print(fi);
         System.out.print(ls);
        email.setText(em);
        first.setText(fi);
      last.setText(ls);
      high.setText(String.valueOf(highscore));
        return  view;





    }


    public class FetchAvatarAsyncTask extends AsyncTask <ImageView,Void,Bitmap>{
        private ImageView imageView;
        private RandomString randomString = new RandomString();

        FetchAvatarAsyncTask(){

        }
FetchAvatarAsyncTask(ImageView v,RandomString s){
    imageView = v;
    randomString = s;
}
        @Override
        protected Bitmap doInBackground(ImageView... params) {
            this.imageView = params[0];
            String rs = this.randomString.generateString(new Random(), RandomString.getSOURCES(), 10);
            StringBuilder sb = new StringBuilder();
            sb.append("https://api.adorable.io/avatars/400/");
            sb.append(rs);
            sb.append(".png");

            Bitmap a = null;

            try {
                java.net.URL url = new URL(sb.toString());

               a= BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return a;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
            super.onPostExecute(bitmap);
        }
    }



}
