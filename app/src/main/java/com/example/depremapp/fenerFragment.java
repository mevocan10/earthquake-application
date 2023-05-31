package com.example.depremapp;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.karumi.dexter.Dexter;

public class fenerFragment extends Fragment {
    private boolean isFlashOn = false;
    private CameraManager cameraManager;
    private String cameraId;
    private boolean isFlashAvailable;
    private boolean isEmulator;

    public fenerFragment() {}

    public static fenerFragment newInstance(String param1, String param2) {
        fenerFragment fragment = new fenerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fener, container, false);
        ImageButton imageButton = view.findViewById(R.id.imgButton);
        isFlashAvailable = getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        isEmulator = Build.DEVICE.startsWith("emu");

        cameraManager = (CameraManager) getActivity().getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        imageButton.setOnClickListener(v -> {
            if (isFlashOn) {
                flashOffMethod();
                imageButton.setImageResource(R.drawable.torch_off);
            } else {
                flashOnMethod();
                imageButton.setImageResource(R.drawable.torch_on);
            }
        });
        return view;
    }

    private void flashOnMethod() {
        try {
            if (isFlashAvailable && !isEmulator) {
                cameraManager.setTorchMode(cameraId, true);
            }
            isFlashOn = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void flashOffMethod() {
        try {
            if (isFlashAvailable && !isEmulator) {
                cameraManager.setTorchMode(cameraId, false);
            }
            isFlashOn = false;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}
