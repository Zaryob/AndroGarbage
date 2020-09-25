package com.example.donunakadar;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class MainActivity extends AppCompatActivity
        implements ActivityCompat.OnRequestPermissionsResultCallback {

    public static final String TAG = "MainActivity";

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private View mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = findViewById(R.id.sample_main_layout);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            PermissionsFragment fragment = new PermissionsFragment();
            transaction.replace(R.id.content_fragment, fragment);
            transaction.commit();
        }
    }
    public void onBack(View view) {
        getSupportFragmentManager().popBackStack();
    }


    public void accessFiles(View view) {
        Log.i(TAG, getResources().getString(R.string.checking_access_files));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            requestExternalStoragePermissions();

        } else {


            Log.i(TAG,
                    getResources().getString(R.string.file_permissions_worked));
            try {
                writeAndReadFile();

                Snackbar.make(mLayout, R.string.file_permissions_worked,
                        Snackbar.LENGTH_LONG).show();
            } catch (IOException e) {
                Snackbar.make(mLayout, R.string.file_permissions_did_not_work,
                        Snackbar.LENGTH_LONG).show();
            }
        }

    }


    private void requestExternalStoragePermissions() {
        Log.i(TAG, getResources().getString(R.string.file_request_permission));

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Log.i(TAG, getResources().getString(R.string.file_permissions_did_not_work));
            Snackbar.make(mLayout, R.string.external_storage_rationale,
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.ok, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                                    REQUEST_EXTERNAL_STORAGE);
                        }
                    }).show();
        } else {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_EXTERNAL_STORAGE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
            @NonNull int[] grantResults) {

        boolean granted = true;
         if (requestCode == REQUEST_EXTERNAL_STORAGE) {
                Log.i(TAG, getResources().getString(R.string.file_permissions_received));

                if (grantResults.length > 0 ) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            granted = false;
                        }
                    }
                } else {
                    granted = false;
                }

                if (granted){
                    Log.i(TAG, getResources().getString(R.string.permission_available_external_storage));
                    Snackbar.make(mLayout, R.string.permission_available_external_storage,
                            Snackbar.LENGTH_SHORT).show();
                } else {
                    Log.i(TAG, getResources().getString(R.string.permissions_not_granted));
                    Snackbar.make(mLayout, R.string.permissions_not_granted,
                            Snackbar.LENGTH_SHORT).show();

                }

        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    private void writeAndReadFile() throws IOException {
        File f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        f.mkdirs();
        File testFile = new File(f,"test.txt");
        PrintStream ps = null;
        try {
            ps = new PrintStream( new FileOutputStream(testFile));
            ps.println("Some data");
        } catch (FileNotFoundException e) {
            Toast.makeText(MainActivity.this, "Exception: see the logs", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if(null != ps) {
                ps.close();
            }
        }

        BufferedReader br = new BufferedReader(new FileReader(testFile));
        try {
            String s = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                br.close();
            }
        }


    }
}
