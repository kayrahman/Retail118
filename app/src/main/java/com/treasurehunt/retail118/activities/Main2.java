package com.treasurehunt.retail118.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.treasurehunt.retail118.R;
import com.treasurehunt.retail118.callback.MyInterface;
import com.treasurehunt.retail118.database.RetailDataSource;
import com.treasurehunt.retail118.fragments.FragmentProductDetail;
import com.treasurehunt.retail118.fragments.LoginFragment;
import com.treasurehunt.retail118.fragments.LoginViewPagerFragment;
import com.treasurehunt.retail118.fragments.ViewPagerFragment;
import com.treasurehunt.retail118.model.MenuItems;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import static android.R.attr.fragment;
import static com.treasurehunt.retail118.helper.Constants.changeStatusBarColor;

public class Main2 extends AppCompatActivity implements LoginFragment.MyAwesomeInterface,MyInterface {

    private Menu mMenu;

    Animation fade_in, fade_out;
  //  ViewFlipper viewFlipper;

    private CallbackManager mManager;
    private LoginManager mLoginManager;

    LoginViewPagerFragment fragmentLogin;

    private ShareDialog mShareDialog;

    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;

    ViewPager mViewPager;

    Window window;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mManager = CallbackManager.Factory.create();


        //
        List<String> permissionNeeded = Arrays.asList("publish_actions");

        mLoginManager = LoginManager.getInstance();

        mLoginManager.logInWithPublishPermissions(this, permissionNeeded);

        mShareDialog = new ShareDialog(this);


      //  viewFlipper = (ViewFlipper) this.findViewById(R.id.viewFlipper);

        fade_in = AnimationUtils.loadAnimation(this,
                R.anim.faded_in);

        fade_out = AnimationUtils.loadAnimation(this,
                R.anim.faded_out);

      /*  viewFlipper.setInAnimation(fade_in);
        viewFlipper.setInAnimation(fade_out);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();
*/

        mViewPager=(ViewPager)findViewById(R.id.viewPager);


        ViewPagerFragment fragment = new ViewPagerFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.placeHolder, fragment);
        fragmentTransaction.commit();

/*

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "nkr.com.blackcactus",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
*/
      /*  window=getWindow();
        changeStatusBarColor(window);*/




        changeStatBarColor();

}


    @Override
    public void onProductListSelected(int index) {

        FragmentProductDetail fragmentProductDetail = new FragmentProductDetail();
        Bundle bundle=new Bundle();
        bundle.putInt(FragmentProductDetail.KEY_INDEX,index);
        fragmentProductDetail.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragmentProductDetail);
        fragmentTransaction.commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        mMenu = menu;

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_login:

                fragmentLogin = new LoginViewPagerFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.placeHolder, fragmentLogin);
                fragmentTransaction.commit();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFbBtnClick() {


        LoginManager.getInstance().registerCallback(mManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                MenuItem welcomeItem = mMenu.findItem(R.id.action_welcome);
                welcomeItem.setTitle("Hi..There..:)" + loginResult.getAccessToken().getUserId());

            }

            @Override
            public void onCancel() {
                Log.d("FACEBOOK LOGIN", "FAILED");
            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    public void onImgShareBtnClick() {

       /* if(ShareDialog.canShow(ShareLinkContent.class)){
            ShareContent linkContent=new ShareLinkContent.Builder()
                    .setContentTitle("First Facebook Post from android")
                    .setContentDescription("Simpple Post")
                    .setContentUrl(Uri.parse("www.facebook.com"))
                    .build();

            mShareDialog.show(linkContent);*/

        selectImage();


    }

    @Override
    public void onLikeBtnClick() {
        Toast.makeText(Main2.this,"Like Button on the go",Toast.LENGTH_LONG).show();
    }

    private void selectImage() {

        final CharSequence[] items = {"Take Photo", "Choose from Library", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Profile Photo");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (items[which].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);

                } else if (items[which].equals("Choose from Library")) {

                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("images/*");
                    startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
                } else if (items[which].equals("Cancel")) {

                    dialog.dismiss();
                }
            }
        });

        builder.show();



     /*   mLoginManager.getInstance().registerCallback(mManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                publishImage();


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
*/


}

    private void publishImage() {

        Bitmap image= BitmapFactory.decodeResource(getResources(),R.drawable.placeholder2);

        SharePhoto sharePhoto=new SharePhoto.Builder()
                .setBitmap(image)
                .setCaption("First Image Sharing")
                .build();

        SharePhotoContent content=new SharePhotoContent.Builder()
                .addPhoto(sharePhoto)
                .build();

        ShareApi.share(content, null);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            mManager.onActivityResult(requestCode,resultCode,data);


        if(resultCode== Activity.RESULT_OK){

            if(requestCode==SELECT_FILE)
                onSelectedFromGalleryResult(data);
            else if(requestCode==REQUEST_CAMERA)
                onCaptureImageResult(data);
        }

    }

    private void onCaptureImageResult(Intent data) {
    }

    private void onSelectedFromGalleryResult(Intent data) {
        Uri selectedImageUri=data.getData();
        String[] projection={MediaStore.MediaColumns.DATA};
       // Cursor cursor=
    }

    public void changeStatBarColor(){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


}
